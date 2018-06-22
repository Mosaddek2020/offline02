import java.util.LinkedList;

public class inventory {

    LinkedList<product> products;

    public inventory(){
        products = new LinkedList<product>();

    }

    void addproduct(String name,int price,int amount){

       product p= new product(name,price,amount);
        products.add(p);

    }
    void showproducts(){
        for (product p: products) {

            System.out.printf("%s %d \n",p.name,p.price);


        }
    }

    int is_available(String s){

        for (product p: products) {

            if(p.name.equalsIgnoreCase(s)){
                if (p.stock_amount > 0){
                    return p.price;
                }
            }
        }
        return  0;
    }

    boolean is_deposite_sufficient(String s,int depos){

        for (product p: products) {

            if(p.name.equalsIgnoreCase(s)){
                if (depos >= p.price){
                    return true;
                }
            }
        }
        return  false;

    }
    boolean is_changes_needed(String s,int depos){

        for (product p: products) {

            if(p.name.equalsIgnoreCase(s)){
                if (depos == p.price){
                    return false;
                }
            }
        }
        return  true;

    }



    boolean dispatch_product(String s){

        for (product p: products) {

            if(p.name.equalsIgnoreCase(s)){
                if (p.stock_amount > 0){
                    p.stock_amount--;
                    return true;
                }
            }
        }
        return  false;

    }

}
