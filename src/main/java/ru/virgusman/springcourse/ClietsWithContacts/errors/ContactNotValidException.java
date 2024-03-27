package ru.virgusman.springcourse.ClietsWithContacts.errors;

public class ContactNotValidException extends RuntimeException{
    public ContactNotValidException(String msg) {
        super(msg);
    }
}
