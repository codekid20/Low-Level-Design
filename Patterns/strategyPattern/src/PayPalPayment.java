public class PayPalPayment implements PaymentStrategy {

    private final String email;

    public PayPalPayment(String email) { this.email = email; }

    @Override
    public void pay(double amount) {
        System.out.println("Charged $" + amount + " via PayPal account " + email);
    }
}
