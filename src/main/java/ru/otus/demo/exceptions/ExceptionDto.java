package ru.otus.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDto {
    private String message;
    private HttpStatus httpStatus;
}