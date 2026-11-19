import config.RateLimiterConfig;
import core.RateLimiter;
import factory.RateLimiterFactory;
import registry.RateLimiterRegistry;

import java.time.Duration;

public class Main {

    public static void main(String[] args) {
        RateLimiterConfig config = new RateLimiterConfig(5, Duration.ofSeconds(1), 5.0);
        RateLimiterRegistry registry = new RateLimiterRegistry(RateLimiterFactory.Algorithm.TOKEN_BUCKET, config);

        String userKey = "user-123";
        for (int i = 0; i < 8; i++) {
            boolean allowed = registry.tryAcquire(userKey);
            System.out.println("Request " + i + ": " + (allowed ? "ALLOWED" : "REJECTED"));
        }
    }
}