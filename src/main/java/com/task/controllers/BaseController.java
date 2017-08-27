package com.task.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by PavelGrudina on 27.08.2017.
 */
@RestController
public abstract class BaseController {


    @ExceptionHandler(IOException.class)
    @ResponseStatus (value = HttpStatus.NOT_FOUND)
    public HttpStatus handleIOException(IOException exception) {
        return HttpStatus.NOT_FOUND;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus (value = HttpStatus.BAD_REQUEST)
    public HttpStatus handleIOException(IllegalArgumentException exception) {
        return HttpStatus.BAD_REQUEST;
    }
}
