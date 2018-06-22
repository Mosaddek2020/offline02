import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

       inventory i = new inventory();

       i.addproduct("7up",5,10);
       i.addproduct("cock",2,10);
       i.addproduct("fanta",10,10);
        i.addproduct("mozo",7,1);


        int a[]={2,5,10,20};
        int b[]={1,3,3,2};
        currency_exchage c = new currency_exchage(4);
        c.addcurrency(a,b);
        Scanner s = new Scanner(System.in);
        order o = new order(i, c);
     while (true) {

         i.showproducts();

         String name = s.next();

         o.select_product(name);
         int j = s.nextInt();
         o.payment(j);

         o.process_order();

     }

    }
}
