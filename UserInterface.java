import java.util.Scanner;

public class UserInterface {

    public static void main(String[] args) {
        UI_Print();
    }

    // Print the UI options and execute their chosen option
    public static void UI_Print() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Select an option from below....");
        System.out.println("1. I am here to order a color.");
        System.out.println("2. I am here to sell a color.");
        System.out.println("3. option to test rgb conversion");
    
        int choice = kb.nextInt(); 
        executeChoice(choice);
        kb.close();
    }

    private static void executeChoice(int choice) {
        if(choice == 1){ //requester
            Buyer b1 = new Buyer();
            b1.promptOrder();
        }
        else if(choice == 2){ //seller
            Seller s1 = new Seller();
        } else if(choice == 3){
            Buyer b1 = new Buyer();
            b1.convertToHex(new int []{220,20,60});
        } 
        else{
            System.out.println("try again with valid input.");
            UI_Print();
        }
    }
}