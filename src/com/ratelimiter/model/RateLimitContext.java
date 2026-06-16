package com.ratelimiter.model;


public class RateLimitContext {

    private final String clientId;

    public RateLimitContext(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }
}