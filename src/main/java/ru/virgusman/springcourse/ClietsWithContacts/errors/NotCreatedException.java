package ru.virgusman.springcourse.ClietsWithContacts.errors;

public class NotCreatedException extends RuntimeException{
    public NotCreatedException(String msg) {
        super(msg);
    }
}
