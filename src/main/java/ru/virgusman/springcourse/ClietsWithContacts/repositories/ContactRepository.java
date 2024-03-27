package ru.virgusman.springcourse.ClietsWithContacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virgusman.springcourse.ClietsWithContacts.models.Contact;
import ru.virgusman.springcourse.ClietsWithContacts.models.ContactType;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
    List<Contact> findByClientId(int id);
    List<Contact> findByClientIdAndType(int id, ContactType type);


}
