package factory;
public class MockPaymentService implements PaymentService {
    @Override public PaymentReceipt pay(double amount) { return new PaymentReceipt(amount, true); }
}
