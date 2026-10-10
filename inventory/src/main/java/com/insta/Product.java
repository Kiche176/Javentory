package com.insta;
import com.fasterxml.jackson.databind.JsonNode;

public class Product {
    private String barcode;
    private String name;
    private String brand;
    private String foodGroup;
    private String imageURL;

    private boolean isVegan;
    private boolean isVegitarian;

    public Product(JsonNode productData) {
        initialiseFields(productData);
    }

    public Product(String barcode) {
        if (!Barcode.checkGTIN(barcode)) throw new IllegalArgumentException("Invalid Barcode");
        API api = new API();
        JsonNode root = api.sendRequest(API.genURL(barcode));
        initialiseFields(root);
    }

    private void initialiseFields(JsonNode productData) {
        initialiseBarcode(productData);
        initialiseName(productData);
        initialiseBrand(productData);
        initialiseFoodGroup(productData);
        initialiseImageURL(productData);

        initialiseIsVegan(productData);
        initialiseIsVegitarian(productData);
    }

    public void printInfo() {
        System.out.println("Product Name: " + this.name + ", ");
        System.out.println("Product Barcode: " + this.barcode + ", ");
        System.out.println("Product Brand: " + this.brand + ", ");
        System.out.println("Product Type of food: " + this.foodGroup + ", ");
        System.out.println("Product Image URL: " + this.imageURL + ", ");
        System.out.println("Product isVegan: " + this.isVegan + ", ");
        System.out.println("Product isVegitarian: " + this.isVegitarian + ".");
        System.out.println();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Product)) return false;

        Product temp = (Product) obj;
        return this.barcode.equals(temp.getBarcode());
    }

    public String getBarcode() {
        return this.barcode;
    }

    private boolean initialiseBarcode(JsonNode root) {
        String barcode = root.path("code").asText("Unknown");
        boolean valid = Barcode.checkGTIN(barcode);
        if (valid) this.barcode = barcode;
        return valid;
    }

    // private boolean setBarcode(String barcode) {
    //     boolean valid = Barcode.checkGTIN(barcode);
    //     if (valid) this.barcode = barcode;
    //     return valid;
    // }


    public String getName() {
        return this.name;
    }

    private void initialiseName(JsonNode root) {
        this.name = root.path("product").path("product_name").asText("Unknown");
    }

    // private void setName(String name) {
    //     this.name = name;
    // }


    public String getBrand() {
        return this.brand;
    }

    private void initialiseBrand(JsonNode root) {
        this.brand = root.path("product").path("brands").asText("Unknown");
    }

    // private void setBrand(String brand) {
    //     this.brand = brand;
    // }


    public String getFoodGroup() {
        return this.foodGroup;
    }

    private void initialiseFoodGroup(JsonNode root) {
        this.foodGroup = root.path("product").path("food_groups").asText("Unknown");
    }

    // private void setFoodGroup(String foodGroup) {
    //     this.foodGroup = foodGroup;
    // }


    public String getImageURL() {
        return this.imageURL;
    }

    private void initialiseImageURL(JsonNode root) {
        this.imageURL = root.path("product").path("image_front_url").asText("Unknown");
    }

    // private void setImageURL(String imageURL) {
    //     this.imageURL = imageURL;
    // }


    public boolean getIsVegan() {
        return this.isVegan;
    }

    private void initialiseIsVegan(JsonNode root) {
        this.isVegan = "yes".equals(root.path("product").path("vegan").asText("Unknown"));
    }

    // private void setIsVegan(boolean isVegan) {
    //     this.isVegan = isVegan;
    // }


    public boolean getIsVegitarian() {
        return this.isVegitarian;
    }

    private void initialiseIsVegitarian(JsonNode root) {
        this.isVegitarian = "yes".equals(root.path("product").path("vegitarian").asText("Unknown"));
    }

    // private void setIsVegitarian(boolean isVegitarian) {
    //     this.isVegitarian = isVegitarian;
    // }

}