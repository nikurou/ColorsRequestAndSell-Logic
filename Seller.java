import java.util.Scanner;

public class Seller {
    
    String name; 
    String hexCode;
    int quantity;
    int[] rgbArray;

	public void promptSellOrder() {
        Scanner kb = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        this.name = kb.nextLine();
       
        System.out.print("Please enter the RGB of the item you would like to sell (r,g,b): ");
        String rgb = kb.nextLine();
        
        System.out.print("Please enter the quantity you'd like to place on the marketplace: ");
        this.quantity = kb.nextInt();
        
        // Take information given and perform parse and conversion to get needed data.
        this.rgbArray = parseRGBString(rgb);
        this.hexCode = convertToHex(rgbArray);
    }

       // given in the form "0-255,0-255,0-255", take each thing into an array
       private int[] parseRGBString(String rgb) {
        String[] parsedRGBString = rgb.split("\\,"); // splits value at , into strings

        // parse each string input into int
        int[] parsedRGB = new int[3];
        for (int i = 0; i < 3; i++) {
            parsedRGB[i] = Integer.parseInt(parsedRGBString[i]);
            System.out.println("RGB = " + parsedRGB[i]);
        }
        return parsedRGB;
    }

    // Convert the RGB array to HEXcode
    public String convertToHex(int[] parsedRGB) {
        String hex = "";
        for (int i = 0; i < 3; i++) {
            int firstDecimal = parsedRGB[i] / 16;
            int secondDecimal = parsedRGB[i] % 16;

            hex += Integer.toHexString(firstDecimal);
            hex += Integer.toHexString(secondDecimal);
        }
        System.out.println("HEX: #" + hex);
        return hex;
    }

    public int[] getRGBArray(){
        return this.rgbArray;
    }
}
