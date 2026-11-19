package factory;

import algorithm.FixedWindowRateLimiter;
import algorithm.SlidingWindowRateLimiter;
import algorithm.TokenBucketRateLimiter;
import config.RateLimiterConfig;
import core.RateLimiter;

public class RateLimiterFactory {

    public enum Algorithm { TOKEN_BUCKET, FIXED_WINDOW, SLIDING_WINDOW }

    public static RateLimiter create(Algorithm algorithm, RateLimiterConfig config) {
        return switch (algorithm) {
            case TOKEN_BUCKET -> new TokenBucketRateLimiter(config);
            case FIXED_WINDOW -> new FixedWindowRateLimiter(config);
            case SLIDING_WINDOW -> new SlidingWindowRateLimiter(config);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        };
    }
}
