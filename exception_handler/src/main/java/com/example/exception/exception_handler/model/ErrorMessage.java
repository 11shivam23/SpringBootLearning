package com.example.exception.exception_handler.model;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
    
    private HttpStatus status;

    private String messgae;

    public ErrorMessage() {
    }

    public ErrorMessage(HttpStatus status, String messgae) {
        this.status = status;
        this.messgae = messgae;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessgae() {
        return messgae;
    }

    public void setMessgae(String messgae) {
        this.messgae = messgae;
    }
}
