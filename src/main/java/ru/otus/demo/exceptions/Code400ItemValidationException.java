package ru.otus.demo.exceptions;

import lombok.NonNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Code400ItemValidationException extends RestException {

    public Code400ItemValidationException(@NonNull Class<?> itemClass, @NonNull UUID id) {
        super(itemClass.getSimpleName() + " with Id=" + id + " validation failed", HttpStatus.BAD_REQUEST);
    }

    public Code400ItemValidationException(@NonNull Class<?> itemClass, @NonNull String name) {
        super(itemClass.getSimpleName() + " with property=" + name + " validation failed", HttpStatus.BAD_REQUEST);
    }

}