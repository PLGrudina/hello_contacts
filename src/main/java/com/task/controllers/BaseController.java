package com.task.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by PavelGrudina on 27.08.2017.
 */
@RestController
public abstract class BaseController {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleException(IllegalArgumentException exception) {
        return exception.getMessage();
    }
}
