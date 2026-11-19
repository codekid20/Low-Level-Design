package algorithm;

import config.RateLimiterConfig;
import core.RateLimiter;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketRateLimiter implements RateLimiter {

    private final int capacity;
    private final double refillRatePerSec;
    private double availableTokens;
    private long lastRefillTimestampNanos;
    private final ReentrantLock lock = new ReentrantLock();

    public TokenBucketRateLimiter(RateLimiterConfig config) {
        this.capacity = config.getCapacity();
        this.refillRatePerSec = config.getRefillRatePerSec();
        this.availableTokens = capacity; // start full
        this.lastRefillTimestampNanos = System.nanoTime();
    }

    @Override
    public boolean tryAcquire() {
        lock.lock();

        try {
            refill();
            if (availableTokens >= 1) {
                availableTokens -= 1;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    private void refill() {

        long now = System.nanoTime();
        double secondsElapsed = (now - lastRefillTimestampNanos) / 1000000000.0;
        double tokensToAdd = secondsElapsed * refillRatePerSec;
        if(tokensToAdd > 0) {
            availableTokens = Math.min(capacity, availableTokens + tokensToAdd);
            lastRefillTimestampNanos = now;
        }
    }
}
