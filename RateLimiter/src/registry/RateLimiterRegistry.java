package registry;

import config.RateLimiterConfig;
import core.RateLimiter;
import factory.RateLimiterFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RateLimiterRegistry {

    private final ConcurrentMap<String, RateLimiter> limiters = new ConcurrentHashMap<>();
    private final RateLimiterFactory.Algorithm algorithm;
    private final RateLimiterConfig config;

    public RateLimiterRegistry(RateLimiterFactory.Algorithm algorithm, RateLimiterConfig config) {
        this.algorithm = algorithm;
        this.config = config;
    }

    public boolean tryAcquire(String key) {
        RateLimiter limiter = limiters.computeIfAbsent(key, k -> RateLimiterFactory.create(algorithm, config));
        return limiter.tryAcquire();
    }
}
