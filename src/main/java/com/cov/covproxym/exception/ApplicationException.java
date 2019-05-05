package com.cov.covproxym.exception;

public class ApplicationException extends RuntimeException {
    private String code;

    public ApplicationException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
