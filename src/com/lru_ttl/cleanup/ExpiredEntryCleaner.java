package com.lru_ttl.cleanup;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExpiredEntryCleaner {

    private final ScheduledExecutorService scheduler;

    public ExpiredEntryCleaner(Runnable cleanupTask) {

        scheduler =
                Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(
                cleanupTask,
                10,
                10,
                TimeUnit.SECONDS
        );
    }

    public void shutdown() {

        scheduler.shutdown();
    }
}