package ru.otus.demo.exceptions;

import lombok.NonNull;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.CONFLICT)
public class Code409ItemConflictException extends RestException {

    public Code409ItemConflictException(@NonNull Class<?> itemClass, @NonNull String name) {
        super(itemClass.getSimpleName() + " with name=" + name + " already exists", HttpStatus.CONFLICT);
    }

    public Code409ItemConflictException(@NonNull Class<?> itemClass, @NonNull UUID id) {
        super(itemClass.getSimpleName() + " already exists id=" + id, HttpStatus.CONFLICT);
    }

}