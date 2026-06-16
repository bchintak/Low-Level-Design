package com.ratelimiter.strategy;

import com.ratelimiter.model.RateLimitContext;
import com.ratelimiter.model.RateLimitRule;

import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindowRateLimiter
        implements RateLimitingStrategy {

    private final ConcurrentHashMap<String,
            Deque<Long>> requestLogs =
            new ConcurrentHashMap<>();

    @Override
    public boolean allowRequest(
            RateLimitContext context,
            RateLimitRule rule) {

        long now = System.currentTimeMillis();

        Deque<Long> queue =
                requestLogs.computeIfAbsent(
                        context.getClientId(),
                        k -> new ConcurrentLinkedDeque<>());

        synchronized (queue) {

            while (!queue.isEmpty()
                    && now - queue.peekFirst()
                    > rule.getWindowSizeMillis()) {

                queue.pollFirst();
            }

            if (queue.size()
                    >= rule.getMaxRequests()) {
                return false;
            }

            queue.addLast(now);

            return true;
        }
    }
}