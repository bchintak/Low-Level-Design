package com.ratelimiter.strategy;

import com.ratelimiter.model.RateLimitContext;
import com.ratelimiter.model.RateLimitRule;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter
        implements RateLimitingStrategy {

    private static class WindowCounter {

        long windowStart;
        AtomicInteger count;

        WindowCounter(long windowStart) {
            this.windowStart = windowStart;
            this.count = new AtomicInteger(0);
        }
    }

    private final ConcurrentHashMap<String, WindowCounter>
            counters = new ConcurrentHashMap<>();

    @Override
    public boolean allowRequest(
            RateLimitContext context,
            RateLimitRule rule) {

        long currentTime = System.currentTimeMillis();

        WindowCounter counter =
                counters.computeIfAbsent(
                        context.getClientId(),
                        k -> new WindowCounter(currentTime));

        synchronized (counter) {

            if (currentTime - counter.windowStart
                    >= rule.getWindowSizeMillis()) {

                counter.windowStart = currentTime;
                counter.count.set(0);
            }

            if (counter.count.get()
                    >= rule.getMaxRequests()) {
                return false;
            }

            counter.count.incrementAndGet();
            return true;
        }
    }
}