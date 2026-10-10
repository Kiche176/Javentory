package com.insta;

import java.util.Scanner;

public class UI {
    public String getBarcode() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter Barcode: ");
        String barcode = s.next();
        s.close();
        return barcode;
    }
}
