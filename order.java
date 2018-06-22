public class order {
    state current_state;

    String productname;
    int deposite;
    inventory Inventory;
    currency_exchage curency;
    public order(inventory in,currency_exchage cur){

        Inventory = in;
        curency = cur;
    }
    public  void select_product(String pName){
        productname = pName;

    }

    public  void payment(int n){

        deposite = n;
        // Inventory.is_deposite_sufficient(productname,diposit);
    }

    public void process_order(){


        if( !Inventory.is_deposite_sufficient(productname,deposite)){

            current_state = new no_delivery_insufficient_deposite();
        }
        else if(Inventory.is_available(productname)==0){
            current_state = new no_delivey_insufficient_product();
        }else if( !Inventory.is_changes_needed(productname,deposite)){
            current_state = new Delivery_with_no_change(productname,Inventory);
        }else if(curency.is_change_available(deposite-Inventory.is_available(productname)))
        {
            current_state = new Deliver_with_change(productname,deposite-Inventory.is_available(productname),curency,Inventory);
        }else{
            current_state = new no_delivery_insufficient_change();
        }




        current_state.handleOrder();
    }



}
