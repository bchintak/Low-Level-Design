package com.ratelimiter;

import com.ratelimiter.factory.RateLimiterType;
import com.ratelimiter.model.RateLimitRule;
import com.ratelimiter.service.RateLimiterService;

public class Main {

    public static void main(String[] args)
            throws Exception {

        RateLimiterService limiter =
                new RateLimiterService(
                        RateLimiterType.SLIDING_WINDOW);

        RateLimitRule rule =
                new RateLimitRule(
                        5,
                        10000);

        for (int i = 1; i <= 10; i++) {

            boolean allowed =
                    limiter.allowRequest(
                            "USER_1",
                            rule);

            System.out.println(
                    "Request "
                            + i
                            + " : "
                            + allowed);

            Thread.sleep(1000);
        }
    }
}