package ru.otus.demo.exceptions;

import lombok.NonNull;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class Code404ItemNotFoundException extends RestException {

    public Code404ItemNotFoundException(@NonNull Class<?> itemClass, @NonNull UUID id) {
        super(itemClass.getSimpleName() + " with Id : " + id + " not found", HttpStatus.NOT_FOUND);
    }

    public Code404ItemNotFoundException(@NonNull Class<?> itemClass, @NonNull String name) {
        super(itemClass.getSimpleName() + " with name : " + name + " not found", HttpStatus.NOT_FOUND);
    }

}