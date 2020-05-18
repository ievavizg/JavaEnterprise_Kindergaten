package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Alternative
public class SpecialPricesGenerator implements Generator{

    public Double generateNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        Double min = 10.0;
        Double max = 30.0;
        double generatedPrice = ThreadLocalRandom.current().nextDouble(min, max);
        double generatedPriceRounded = Math.round(generatedPrice * 100.0) / 100.0;
        return generatedPriceRounded;
    }

}
