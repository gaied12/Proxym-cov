package com.cov.covproxym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You must have a Profil to authenticate ")

public class Inscription  extends RuntimeException{

}
