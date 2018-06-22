public class Deliver_with_change implements state{

    int change;
    currency_exchage cur;
    inventory Invetory;
    String productname;
    @Override
    public void handleOrder() {
        cur.calculate_change(change);
        Invetory.dispatch_product(productname);
    }


    public  Deliver_with_change(String str,int n, currency_exchage cur,inventory in) {

        change = n;
        this.cur = cur;
        Invetory = in;
        productname = str;


    }
}
