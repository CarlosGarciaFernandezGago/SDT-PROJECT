package pricing;
public class DistancePricing implements PricingStrategy {
    @Override public double price(int minutes, double km){ return 0.5 * km; }
}
