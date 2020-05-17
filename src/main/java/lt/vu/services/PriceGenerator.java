package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

@ApplicationScoped
public class PriceGenerator implements Generator {

    public Double generateNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        Double generatedPrice = (double)Math.round((new Random().nextDouble() * (5 - 0) + 1 /2) * 100d) / 100d;
        return generatedPrice;
    }

}
