package ru.otus.demo.exceptions;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestControllerAdviceExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<ExceptionDto> handleException(RestException ex) {

        log.error("Caught rest exception {}", ex.toString());

        return ResponseEntity.status(ex.getHttpStatus())
                .body(ExceptionDto.builder()
                .message(ex.getMsg())
                .httpStatus(ex.getHttpStatus())
            .build()
        );
    }

}