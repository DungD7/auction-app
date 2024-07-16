package com.example.auctionappver2.model;

import java.io.Serializable;

public class PostActiveAccountResponse implements Serializable {
    private String cause;
    private String errorCode;
    private String defaultMessage;
    private String message;

    public PostActiveAccountResponse(String cause, String errorCode, String defaultMessage) {
        this.cause = cause;
        this.errorCode = errorCode;
        this.defaultMessage = defaultMessage;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
