package ru.virgusman.springcourse.ClietsWithContacts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.virgusman.springcourse.ClietsWithContacts.models.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByName(String name);
}
