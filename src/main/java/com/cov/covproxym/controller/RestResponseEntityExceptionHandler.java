package com.cov.covproxym.controller;

import com.cov.covproxym.exception.ApplicationException;
import com.cov.covproxym.exception.ExceptionMetaData;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {ApplicationException.class})
    protected ResponseEntity < Object >  handleConflict(ApplicationException ex) {
        return ResponseEntity.ok().headers(null).body(new ExceptionMetaData(ex.getCode(),ex.getMessage()));

    }

    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity < Object >
    handleConflict(RuntimeException ex) {
        return ResponseEntity.ok().headers(null).body(new ExceptionMetaData("100","Error generale not handling"));
    }
}