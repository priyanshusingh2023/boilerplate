package com.stackroute.HealthMonitoring.Exceptions;

public class ResourceNotFoundException extends Exception {
    private static final long serialVersionUID = 7357853113929996390L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
