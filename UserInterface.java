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
            executeChoice(choice);
        }
    }


    private void executeChoice(int choice) {
      
        if (choice == 1) { // requester
            Buyer b1 = new Buyer();
            b1.promptOrder();
            // Now b1 contains the order's details. Let's push it to rq_db
            // but first, let's check if their request is already on the markt
            checkMarket(b1); 
            
        } else if (choice == 2) { // seller
            Seller s1 = new Seller();
            s1.promptSellOrder();
            // Now s1 contains the item details, let's push it mrkt_db
            mrkt_db.add(s1);
            // Find any users that want this dye, and notify them.
            checkAndNotifyRQ(s1); 
        } else if (choice == 3) {
            System.out.println("Exited!");
        } else {
            System.out.println("try again with valid input.");
            UI_Print();
        }
    }

    // Called whenever a dye is added to the mrkt_db.
    // Check if the dye is desired by any customers, and notify the customer a day they're interested in is out
    private void checkAndNotifyRQ(Seller s1) {
        Scanner kb = new Scanner(System.in);
        int[] sellerRGB = s1.getRGBArray();


        for(Buyer i: rq_db){
            int[] clientRGB = i.getRGBArray();
            int offset = i.getRangeOfError();
            int difference = Math.abs(clientRGB[0] - sellerRGB[0]) +  
                             Math.abs(clientRGB[1] - sellerRGB[1]) + 
                             Math.abs(clientRGB[2] - sellerRGB[2]);

            if( difference <= offset){
                //Code or function to send notification to potential buyer.
                System.out.println("Notified customer " + i.name + " that an item they want is on sale.");
            }                  
            
        }
    }

    private void checkMarket(Buyer b1) {

        Scanner kb = new Scanner(System.in);
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

        if(acceptableItems.size() >= 1){
            System.out.println("We have found items matching your criteria from the following sellers: ");

            for(Seller i: acceptableItems){
                System.out.println("Name: " + i.name + "HexCode: " + i.hexCode + "RGB = (" + i.rgbArray[0] +", " + i.rgbArray[1] + ", " + i.rgbArray[2] + ") Price: " + i.price);
            }
    
            System.out.println("Would you like to proceed with your order anyways? [Y/N]: ");
            if(kb.nextLine().equals("Y")){
                rq_db.add(b1);
                System.out.println("Sucessfully added your order to the rq_db");
            }
            else{
                System.out.println("Your order was not placed.");
            }
        }
    }
}