package com.example.auctionappver2.model;

import java.io.Serializable;

public class PostRegisterAccountResponse implements Serializable {
    private String cause;
    private int errorCode;
    private String defaultMessage;
    private String message;
    private String suppressed;
    private String localizedMessage;
    private int id;
    private String username;
    private String email;
    private String fullname;
    private String phone;
    private boolean actived;
    private String createdDate;
    private String tokenFcm;


    public PostRegisterAccountResponse(String cause, int errorCode, String defaultMessage, String message, String suppressed, String localizedMessage, int id, String username, String email, String fullname, String phone, boolean actived, String createdDate, String tokenFcm) {
        this.cause = cause;
        this.errorCode = errorCode;
        this.defaultMessage = defaultMessage;
        this.message = message;
        this.suppressed = suppressed;
        this.localizedMessage = localizedMessage;
        this.id = id;
        this.username = username;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.actived = actived;
        this.createdDate = createdDate;
        this.tokenFcm = tokenFcm;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
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

    public String getSuppressed() {
        return suppressed;
    }

    public void setSuppressed(String suppressed) {
        this.suppressed = suppressed;
    }

    public String getLocalizedMessage() {
        return localizedMessage;
    }

    public void setLocalizedMessage(String localizedMessage) {
        this.localizedMessage = localizedMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getTokenFcm() {
        return tokenFcm;
    }

    public void setTokenFcm(String tokenFcm) {
        this.tokenFcm = tokenFcm;
    }
}
