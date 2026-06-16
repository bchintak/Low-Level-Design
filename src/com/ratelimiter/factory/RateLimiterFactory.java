package com.ratelimiter.factory;

import com.ratelimiter.strategy.*;

public class RateLimiterFactory {

    public static RateLimitingStrategy create(
            RateLimiterType type) {

        return switch (type) {

            case FIXED_WINDOW ->
                    new FixedWindowRateLimiter();

            case SLIDING_WINDOW ->
                    new SlidingWindowRateLimiter();

            case TOKEN_BUCKET ->
                    new TokenBucketRateLimiter();
        };
    }
}