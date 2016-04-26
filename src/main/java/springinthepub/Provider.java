package springinthepub;


public class Provider {
    public static double beerLimit = 10000.0;

    public static boolean sendOrder(double orderSize) {
        boolean isOrderApproved = false;
        if (beerLimit - orderSize > 0) {
            beerLimit -= orderSize;
            isOrderApproved = true;
        }
        return isOrderApproved;
    }


}
