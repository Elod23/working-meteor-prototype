package com.prototype.meteor.controllers.resources;

public enum ErrorDetails {
    OK(0);

    private int code;
    private String message;

    ErrorDetails(int code, String message) {
        this.code = code;
        this.message = message;
    }

    ErrorDetails(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
