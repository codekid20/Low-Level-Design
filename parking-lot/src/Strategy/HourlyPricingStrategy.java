package Strategy;

import model.Ticket;

import java.time.Duration;

public class HourlyPricingStrategy implements PricingStrategy {

    private static final double RATE_PER_HOUR = 2.0;

    @Override
    public double calculateFee(Ticket ticket){
        Duration duration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = Math.max(1, duration.toMinutes() / 60 + (duration.toMinutes() % 60 > 0 ? 1 : 0));
        return hours * RATE_PER_HOUR;
    }
}
