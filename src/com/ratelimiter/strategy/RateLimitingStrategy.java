package com.ratelimiter.strategy;

import com.ratelimiter.model.RateLimitContext;
import com.ratelimiter.model.RateLimitRule;

public interface RateLimitingStrategy {

    boolean allowRequest(
            RateLimitContext context,
            RateLimitRule rule);
}