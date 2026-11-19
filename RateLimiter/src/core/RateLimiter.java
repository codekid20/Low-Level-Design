package core;

public interface RateLimiter {
    boolean tryAcquire();
}
