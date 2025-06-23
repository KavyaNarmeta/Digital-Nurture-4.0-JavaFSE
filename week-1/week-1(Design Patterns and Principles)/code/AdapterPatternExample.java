interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee 1
class PayPalGateway {
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Adaptee 2
class StripeGateway {
    public void doPayment(double amount) {
        System.out.println("Paid " + amount + " using Stripe.");
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway gateway = new PayPalGateway();

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private StripeGateway gateway = new StripeGateway();

    public void processPayment(double amount) {
        gateway.doPayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPalAdapter();
        paypal.processPayment(150.0);

        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(200.0);
    }
}
