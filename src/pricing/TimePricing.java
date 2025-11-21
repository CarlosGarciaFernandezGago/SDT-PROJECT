package pricing;
public class TimePricing implements PricingStrategy {
    @Override public double price(int minutes, double km){ return 0.15 * minutes; }
}
