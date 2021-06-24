package Projects.BestPriceFinder;

public class GetPrice {

    public int getPrice(String site){

        try {
            Thread.sleep((long) (5000*Math.random()));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        var s = site.replace("site", "");
        var num = Integer.parseInt(s);

        return (int) (100 + (10*Math.random()) + num);
    }
    
    
}
