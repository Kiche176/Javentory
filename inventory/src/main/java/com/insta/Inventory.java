package com.insta;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class Inventory {
    private List<Item> inventory = new ArrayList<>();
    private API api = new API();

    public void addProduct(String barcode) {
        // check the database for a product with the matching barcode
        JsonNode node = api.sendRequest(API.genURL(barcode));

        // check if the product is in the inventory
        // if it is increment the quantity, otherwise add it to the inventory
        boolean found = false;
        for (Item item : inventory) {
            if (item.getProduct().getBarcode().equals(node.get("code").asText())) {
                item.incrementQuantity();
                found = true;
            }
        }
        if (!found) inventory.add(new Item(new Product(node)));
    }

    public Product[] listInventory() {
        return (Product[]) this.inventory.toArray(new Product[0]);
    }

    public void printInventory() {
        for (Item item : this.inventory) item.printInfo();
    }
}