package com.ratelimiter.strategy;

import com.ratelimiter.model.RateLimitContext;
import com.ratelimiter.model.RateLimitRule;

import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter
        implements RateLimitingStrategy {

    private final ConcurrentHashMap<String,
            TokenBucket> buckets =
            new ConcurrentHashMap<>();

    @Override
    public boolean allowRequest(
            RateLimitContext context,
            RateLimitRule rule) {

        TokenBucket bucket =
                buckets.computeIfAbsent(
                        context.getClientId(),
                        k -> new TokenBucket(
                                rule.getMaxRequests(),
                                rule.getMaxRequests()));

        return bucket.allowRequest();
    }
}