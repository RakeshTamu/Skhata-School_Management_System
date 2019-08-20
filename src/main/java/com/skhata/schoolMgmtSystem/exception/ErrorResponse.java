package com.skhata.schoolMgmtSystem.exception;

import java.util.List;

/**
 * Created by Rakesh Gurung on 18,Aug,2019
 */
public class ErrorResponse {

    private Boolean error;
    private String message;
    private List<String> details;

    public ErrorResponse(Boolean error, String message, List<String> details) {
        this.error = error;
        this.message = message;
        this.details = details;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
