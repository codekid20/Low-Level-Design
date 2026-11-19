public class Main {
    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment("123456789"));
        cart.checkout(50);

        cart.setPaymentStrategy(new PayPalPayment("adi@email.com"));
        cart.checkout(40);
    }
}