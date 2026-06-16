package com.ratelimiter.service;

import com.ratelimiter.factory.RateLimiterFactory;
import com.ratelimiter.factory.RateLimiterType;
import com.ratelimiter.model.RateLimitContext;
import com.ratelimiter.model.RateLimitRule;
import com.ratelimiter.strategy.RateLimitingStrategy;

public class RateLimiterService {

    private final RateLimitingStrategy strategy;

    public RateLimiterService(
            RateLimiterType type) {

        this.strategy =
                RateLimiterFactory.create(type);
    }

    public boolean allowRequest(
            String clientId,
            RateLimitRule rule) {

        return strategy.allowRequest(
                new RateLimitContext(clientId),
                rule);
    }
}