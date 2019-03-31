package com.cov.covproxym.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User_Exist")

public class NoUser  extends RuntimeException{

}
