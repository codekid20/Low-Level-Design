package algorithm;

import config.RateLimiterConfig;
import core.RateLimiter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class FixedWindowRateLimiter implements RateLimiter {

    private final int capacity;
    private final long windowSizeMillis;
    private long currentWindowStart;
    private final AtomicInteger requestCount = new AtomicInteger(0);
    private final ReentrantLock lock = new ReentrantLock();

    public FixedWindowRateLimiter(RateLimiterConfig config) {
        this.capacity = config.getCapacity();
        this.windowSizeMillis = config.getWindow().toMillis();
        this.currentWindowStart = System.currentTimeMillis();
    }

    @Override
    public boolean tryAcquire() {
        lock.lock();
        try {
            long now = System.currentTimeMillis();
            if (now - currentWindowStart >= windowSizeMillis) {
                currentWindowStart = now;
                requestCount.set(0);
            }

            if (requestCount.get() < capacity) {
                requestCount.incrementAndGet();
                return true;
            }

            return false;
        } finally {
            lock.unlock();
        }
    }
}
