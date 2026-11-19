package Strategy;

import model.Ticket;

public interface PricingStrategy {
    double calculateFee(Ticket ticket);
}
