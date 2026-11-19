public class CreditCardPayment implements PaymentStrategy{

    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Charged $" + amount + " to card ending in "
                + cardNumber.substring(cardNumber.length() - 4));
    }
}
