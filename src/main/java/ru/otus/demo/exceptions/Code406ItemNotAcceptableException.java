package ru.otus.demo.exceptions;

import lombok.NonNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class Code406ItemNotAcceptableException extends RestException {

    public Code406ItemNotAcceptableException(@NonNull Class<?> itemClass, @NonNull String name) {
        super(itemClass.getSimpleName() + " with name=" + name + " cant be edited ", HttpStatus.NOT_ACCEPTABLE);
    }

    public Code406ItemNotAcceptableException(@NonNull Class<?> itemClass, @NonNull UUID id) {
        super(itemClass.getSimpleName() + " cant be edited=" + id, HttpStatus.NOT_ACCEPTABLE);
    }

}