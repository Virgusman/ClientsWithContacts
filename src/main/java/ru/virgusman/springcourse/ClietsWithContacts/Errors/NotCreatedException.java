package ru.virgusman.springcourse.ClietsWithContacts.Errors;

public class NotCreatedException extends RuntimeException{
    public NotCreatedException(String msg) {
        super(msg);
    }
}
