package com.example.restuserstore.response;

/**
 * @author : anisuzzaman
 * @created : 7/11/21, Sunday
 **/
public class ExceptionResponse {
    private String errorMessage;

    public ExceptionResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
