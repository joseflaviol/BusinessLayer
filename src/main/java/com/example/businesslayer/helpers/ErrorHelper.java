package com.example.businesslayer.helpers;

public class ErrorHelper {

    private boolean error;
    private String message;

    public ErrorHelper(String message) {
        this.error = true;
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
