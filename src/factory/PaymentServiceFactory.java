package factory;
public class PaymentServiceFactory {
    public PaymentService create(){ return new MockPaymentService(); }
}
