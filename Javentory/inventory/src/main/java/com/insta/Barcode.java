// This class is full of the static methods meant to handle barcode validation
package com.insta;

public class Barcode {
    /**
     * The final digit of a Universal Product Code, 
     * International Article Number, Global Location Number or Global Trade Item Number 
     * is a check digit computed as follows
     * Global Trade Item Number
     */
    public static boolean checkGTIN(String barcode) {
        if (barcode.length() != 8 && !(barcode.length() >= 12 && barcode.length() <= 14)) return false;

        int total = 0;
        for (int i = barcode.length() - 2; i >= 0; i--) {
            int toAdd = barcode.charAt(i) - 48;
            total += toAdd * (((barcode.length() - i) % 2 == 0) ? 3 : 1);
        }
        
        int check = (10 - (total % 10)) % 10;
        return check == ((int) barcode.charAt(barcode.length() - 1)) - 48;
    }
}
