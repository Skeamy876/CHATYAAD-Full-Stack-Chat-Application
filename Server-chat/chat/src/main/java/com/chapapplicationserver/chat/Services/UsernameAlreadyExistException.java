package com.chapapplicationserver.chat.Services;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyExistException extends Exception {

    public UsernameAlreadyExistException(String message) {
        super(message);
    }



}
