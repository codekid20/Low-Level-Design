package algorithm;

import config.RateLimiterConfig;
import core.RateLimiter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

public class SlidingWindowRateLimiter implements RateLimiter {

    private final int capacity;
    private final long windowSizeMillis;
    private final Deque<Long> requestTimestamps = new ArrayDeque<>();
    private final ReentrantLock lock = new ReentrantLock();

    public  SlidingWindowRateLimiter(RateLimiterConfig config) {
        this.capacity = config.getCapacity();
        this.windowSizeMillis = config.getWindow().toMillis();
    }

    @Override
    public boolean tryAcquire() {
        lock.lock();
        try {
            long now = System.currentTimeMillis();
            long windowStart = now - windowSizeMillis;

            while (!requestTimestamps.isEmpty() && requestTimestamps.peekFirst() < windowStart) {
                requestTimestamps.pollLast();
            }

            if (requestTimestamps.size() < capacity) {
                requestTimestamps.addLast(now);
                return true;
            }

            return false;
        } finally {
            lock.unlock();
        }
    }
}
