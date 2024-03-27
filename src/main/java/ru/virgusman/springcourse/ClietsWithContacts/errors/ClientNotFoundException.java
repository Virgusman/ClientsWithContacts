package ru.virgusman.springcourse.ClietsWithContacts.errors;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String msg) {
        super(msg);
    }
}
