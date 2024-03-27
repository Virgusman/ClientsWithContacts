package ru.virgusman.springcourse.ClietsWithContacts.Errors;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException(String msg) {
        super(msg);
    }
}
