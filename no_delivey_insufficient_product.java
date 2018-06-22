public class no_delivey_insufficient_product implements state {
    @Override
    public void handleOrder() {
        System.out.println("no delivery because of insufficient product");

    }
}
