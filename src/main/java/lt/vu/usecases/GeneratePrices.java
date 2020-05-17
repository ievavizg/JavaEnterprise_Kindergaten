package lt.vu.usecases;

import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.Generator;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GeneratePrices  implements Serializable {

    @Inject
    Generator generator;

    private CompletableFuture<Double> priceGenerationTask = null;

    @LoggedInvocation
    public String generatePrices() {
        priceGenerationTask = CompletableFuture.supplyAsync(() -> generator.generateNumber());

        return  "/index.xhtml";
    }

    public boolean isGenerationRunning() {
        return priceGenerationTask != null && !priceGenerationTask.isDone();
    }

    public String getGenerationStatus() throws ExecutionException, InterruptedException {
        if (priceGenerationTask == null) {
            return null;
        }
        else if (isGenerationRunning()) {
            return " Getting meal price...";
        }
        return " Meal price: " + priceGenerationTask.get();
    }
}
