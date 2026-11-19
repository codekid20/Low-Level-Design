package config;

import java.time.Duration;

public final class RateLimiterConfig {
    private final int capacity; // max tokens / max requests per window
    private final Duration window; // window size (fixed / sliding window)

    private final double refillRatePerSec; // tokens per second (token bucket)

    public RateLimiterConfig(int capacity, Duration window, double refillRatePerSec) {
        this.capacity = capacity;
        this.window = window;
        this.refillRatePerSec = refillRatePerSec;
    }

    public int getCapacity() { return capacity; }
    public Duration getWindow() { return window; }
    public double getRefillRatePerSec() { return refillRatePerSec; }
}
