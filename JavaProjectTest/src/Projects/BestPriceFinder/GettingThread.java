package Projects.BestPriceFinder;

import java.util.concurrent.CompletableFuture;

public class GettingThread {
    public CompletableFuture<String> getThreads(String site) {

        GettingQuote getquote = new GettingQuote();
        GetPrice getprice = new GetPrice();
        GetSite getsite = new GetSite();

        return CompletableFuture
                        .supplyAsync(() -> getquote.getQuoteSite(getsite.getSite(Integer.parseInt(site))))
                        .thenApplyAsync(quote ->{
                                                    System.out.println("Getting a quote from " + quote);
                                                    return quote;
                                            })                       
                        .thenApplyAsync(quote -> {
                                                    var getValues = new String[2];
                                                    getValues[0] = quote;
                                                    var price = getprice.getPrice(quote);
                                                    getValues[1] = Integer.toString(price);
                                                   return getValues;
                                                })
                        .thenApplyAsync(values -> {
                                                    return ("Quote{site='" + values[0] + "', price=" + values[1] + "}");
                                                });
        
        
    }
}
