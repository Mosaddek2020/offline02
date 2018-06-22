public class order {
    state current_state;

    String productname;
    int deposite;
    inventory Inventory;

    public order(inventory in){
        Inventory = in;
    }
    public  void select_product(String pName){
        productname = pName;

    }

    public  void payment(int n){

        deposite = n;
        // Inventory.is_deposite_sufficient(productname,diposit);
    }

    public void process_order(){

        current_state.handleOrder();
    }

    public void change_state(){




    }

}
