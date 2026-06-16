package com.ratelimiter.strategy;

public class TokenBucket {

    private final int capacity;

    private final double refillRate;

    private double tokens;

    private long lastRefillTime;

    public TokenBucket(int capacity,
                       double refillRate) {

        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {

        refill();

        if (tokens < 1) {
            return false;
        }

        tokens--;

        return true;
    }

    private void refill() {

        long now = System.currentTimeMillis();

        long elapsed = now - lastRefillTime;

        double newTokens =
                (elapsed / 1000.0) * refillRate;

        tokens =
                Math.min(capacity,
                        tokens + newTokens);

        lastRefillTime = now;
    }
}