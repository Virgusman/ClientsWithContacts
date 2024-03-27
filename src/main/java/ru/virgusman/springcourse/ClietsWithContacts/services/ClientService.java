package ru.virgusman.springcourse.ClietsWithContacts.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.virgusman.springcourse.ClietsWithContacts.dto.ClientDTO;
import ru.virgusman.springcourse.ClietsWithContacts.dto.ContactDTO;
import ru.virgusman.springcourse.ClietsWithContacts.errors.ClientNotFoundException;
import ru.virgusman.springcourse.ClietsWithContacts.errors.ContactNotValidException;
import ru.virgusman.springcourse.ClietsWithContacts.models.Client;
import ru.virgusman.springcourse.ClietsWithContacts.models.Contact;
import ru.virgusman.springcourse.ClietsWithContacts.models.ContactType;
import ru.virgusman.springcourse.ClietsWithContacts.repositories.ClientRepository;
import ru.virgusman.springcourse.ClietsWithContacts.repositories.ContactRepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ClientService {

    private final ClientRepository clientRepository;
    private final ModelMapper modelMapper;
    private final ContactRepository contactRepository;

    public ClientService(ClientRepository clientRepository, ModelMapper modelMapper, ContactRepository contactRepository) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
        this.contactRepository = contactRepository;
    }

    public Optional<Client> findOneByName(String name) {
        return clientRepository.findByName(name);
    }

    @Transactional
    public void save(ClientDTO clientDTO) {
        clientRepository.save(modelMapper.map(clientDTO, Client.class));
    }

    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream().map(n -> modelMapper.map(n, ClientDTO.class)).collect(Collectors.toList());
    }

    public ClientDTO findOneById(int id) {
        return modelMapper.map(clientRepository
                .findById(id)
                .orElseThrow(() -> new ClientNotFoundException(String.format("Клиент %s не найден", id))), ClientDTO.class);
    }

    @Transactional
    public void save(ContactDTO contactDTO, int id) {
        Contact contact = modelMapper.map(contactDTO, Contact.class);
        contact.setClient(clientRepository
                .findById(id)
                .orElseThrow(() -> new ClientNotFoundException(String.format("Клиент %s не найден", id))));
        switch (contact.getType()) {
            case PHONE -> {
                String regexPattern = "^((\\+7|7|8)+([0-9]){10})$";
                if (!Pattern.compile(regexPattern).matcher(contact.getValue()).matches()) {
                    throw new ContactNotValidException("Номер телефона не корректен!");
                }
            }
            case EMAIL -> {
                String regexPattern = "^(\\S+)@([a-z0-9-]+)(\\.)([a-z]{2,4})(\\.?)([a-z]{0,4})+$";
                if (!Pattern.compile(regexPattern).matcher(contact.getValue()).matches()) {
                    throw new ContactNotValidException("Email не корректен!");
                }
            }
        }
        contactRepository.save(contact);
    }

    public List<ContactDTO> findClientContacts(int id, String type) {
        if (type == null) {
            return contactRepository.findByClientId(id)
                    .stream()
                    .map(n -> modelMapper.map(n, ContactDTO.class))
                    .collect(Collectors.toList());
        }
        ContactType contactType = ContactType.valueOf(type);
        return contactRepository.findByClientIdAndType(id, contactType)
                .stream()
                .map(n -> modelMapper.map(n, ContactDTO.class))
                .collect(Collectors.toList());
    }
}
