package ru.virgusman.springcourse.ClietsWithContacts.Errors;

public class ContactNotValidException extends RuntimeException{
    public ContactNotValidException(String msg) {
        super(msg);
    }
}
