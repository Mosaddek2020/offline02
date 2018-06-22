public class Delivery_with_no_change implements state {

    String productname;
    inventory Inventory;
    Delivery_with_no_change(String str,inventory in){

        productname = str;
        Inventory = in;
    }
    @Override
    public void handleOrder() {

        System.out.printf("delivery of product %s with  no changes \n",productname);
        Inventory.dispatch_product(productname);


    }
}
