public class no_delivery_insufficient_change implements state {
    @Override
    public void handleOrder() {
        System.out.println("no delivery because of being unable to give changes ");
    }
}
