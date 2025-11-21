package pricing;
public interface PricingStrategy {
    double price(int minutes, double km);
}
