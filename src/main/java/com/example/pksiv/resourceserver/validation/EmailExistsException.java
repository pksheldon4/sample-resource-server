package com.example.pksiv.resourceserver.validation;

public class EmailExistsException extends Throwable {

    public EmailExistsException(final String message) {
        super(message);
    }

}