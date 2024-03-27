package ru.virgusman.springcourse.ClietsWithContacts.DTO;

import lombok.Getter;

import java.util.List;

@Getter
public class ContactResponse {
    private List<ContactDTO> contacts;

    public ContactResponse(List<ContactDTO> contacts) {
        this.contacts = contacts;
    }
}
