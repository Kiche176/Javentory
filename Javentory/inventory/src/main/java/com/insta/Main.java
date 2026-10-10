package com.insta;

public class Main {

    public static void main(String[] args) {
    
        String tempCode1 = "5000128104517";
        String tempCode2 = "5038862102704";
        String tempCode3 = "5038862104708";
        String tempCode4 = "5000128412773";
        String tempCode5 = "5010238297115";

        String[] practiceCodes = {tempCode1, tempCode2, tempCode3, tempCode4, tempCode5};

        Inventory inv = new Inventory();
        for (String code : practiceCodes) inv.addProduct(code);
        inv.printInventory();
    }   
}