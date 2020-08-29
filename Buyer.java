import java.util.Scanner;

public class Buyer {


    // In the final project all this input and error checking will be handled by the UI component.
	public void promptOrder() {
        Scanner kb = new Scanner(System.in);
        // In final product, user logs in to account so we won't ask this.
        System.out.print("Please enter your name: ");
        String name = kb.nextLine(); 
        //In the final project, you will have the option to give HEX instead too, but let's assume user always enters RGB for simplicity during this prototype.
        System.out.print("Please enter the RGB of the item you would like to order (r,g,b): "); 
        String rgb = kb.nextLine();
        System.out.print("Please define a range of error or enter 0 for exact: ");
        int rangeOfError = kb.nextInt();
        System.out.print("Please enter the quantity you'd like to order: ");
        int quantity = kb.nextInt();

        placeOrder(name, rgb, rangeOfError, quantity);
        kb.close();
	}

    private void placeOrder(String name, String rgb, int rangeOfError, int quantity) {
    }

    private void parseRGBString(String rgb){

    }

}
