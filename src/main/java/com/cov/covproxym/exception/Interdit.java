package com.cov.covproxym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You dont have  acces from Ldap ")

public class Interdit extends RuntimeException {

}
