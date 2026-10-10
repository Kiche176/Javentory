package com.insta;
import java.time.LocalDate;

public class Item {
    private Product product;
    private int quantity;
    private LocalDate expiration;

    public Item(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public void printInfo() {
        System.out.println("Product Name: " + this.product.getName() + ", ");
        System.out.println("Product Barcode: " + this.product.getBarcode() + ", ");
        System.out.println("Product Quantity: " + this.quantity + ", ");
        System.out.println("Product Brand: " + this.product.getBrand() + ", ");
        System.out.println("Product Expiration Date: " + this.expiration + ", ");
        System.out.println("Product Type of food: " + this.product.getFoodGroup() + ", ");
        System.out.println("Product Image URL: " + this.product.getImageURL() + ", ");
        System.out.println("Product isVegan: " + this.product.getIsVegan() + ", ");
        System.out.println("Product isVegitarian: " + this.product.getIsVegitarian() + ".");
        System.out.println();
    }

    public Product getProduct() {
        return this.product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public int getQuantity() {
        return this.quantity;
    }

    public void incrementQuantity() {
        this.quantity++;
    }

    public void incrementQuantity(int amount) {
        this.quantity += amount;
    }

    public boolean decrementQuantity() {
        if (this.quantity == 0) return false;
        this.quantity--;
        return true;
    }

    public LocalDate getExpiration() {
        return this.expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

}
