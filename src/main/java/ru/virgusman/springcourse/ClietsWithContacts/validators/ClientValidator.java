package ru.virgusman.springcourse.ClietsWithContacts.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.virgusman.springcourse.ClietsWithContacts.DTO.ClientDTO;
import ru.virgusman.springcourse.ClietsWithContacts.models.Client;
import ru.virgusman.springcourse.ClietsWithContacts.services.ClientService;

@Component
public class ClientValidator implements Validator {

    private final ClientService clientService;

    public ClientValidator(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ClientDTO clientDTO = (ClientDTO) target;
        if (clientService.findOneByName(clientDTO.getName()).isPresent()) {
            errors.rejectValue("name", "", "Данный клиент уже заведён");
        }
    }
}
