package pricing;
import java.time.LocalTime;
public class PeakHoursPricing implements PricingStrategy {
    @Override public double price(int minutes, double km){
        double base = 0.12 * minutes + 0.3 * km;
        int h = LocalTime.now().getHour();
        return (h>=8 && h<=9) || (h>=18 && h<=19) ? base * 1.25 : base;
    }
}
