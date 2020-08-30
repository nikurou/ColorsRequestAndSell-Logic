import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    ArrayList<Buyer> rq_db = new ArrayList<Buyer>(); // simulates the DB for request
    ArrayList<Seller> mrkt_db = new ArrayList<Seller>(); // simulate the seller DB

    // Print the UI options and execute their chosen option
    public void UI_Print() {

        int choice = 0;

        Scanner kb = new Scanner(System.in);
        while (choice != 3) {
            System.out.println("Select an option from below....");
            System.out.println("1. I am here to order a color.");
            System.out.println("2. I am here to sell a color.");
            System.out.println("3. Exit.");

            choice = kb.nextInt();
            kb.nextLine();
            System.out.println("bbbbb");
            
            executeChoice(choice);
            System.out.println("aaaaaaa");
        }
    }


    private void executeChoice(int choice) {
      
        if (choice == 1) { // requester
            Buyer b1 = new Buyer();
            b1.promptOrder();
            // Now b1 contains the order's details. Let's push it to rq_db
            // but first, let's check if their request is already on the markt

            
        } else if (choice == 2) { // seller
            Seller s1 = new Seller();
            s1.promptSellOrder();
            // Now s1 contains the item details, let's push it mrkt_db
            mrkt_db.add(s1);
        } else if (choice == 3) {
            System.out.println("Exited!");
        } else {
            System.out.println("try again with valid input.");
            UI_Print();
        }
    }

    private boolean checkMarket(Buyer b1) {

        int[] clientRGB = b1.getRGBArray();
        int offset = b1.getRangeOfError();

        ArrayList<Seller> acceptableItems = new ArrayList<Seller>();

        for( Seller i : mrkt_db){
            int[] sellerRGB = i.getRGBArray();
            int difference = Math.abs(clientRGB[0] - sellerRGB[0]) +  
                             Math.abs(clientRGB[1] - sellerRGB[1]) + 
                             Math.abs(clientRGB[2] - sellerRGB[2]);

            if( difference <= offset){
                acceptableItems.add(i);
            }
        }

        System.out.println("");
        return false;

    }
}