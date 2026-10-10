package com.insta;

import java.net.URI; // create web addresses
import java.net.http.HttpClient; // handles the sending of requests
import java.net.http.HttpRequest; // stores what will be sent 
import java.net.http.HttpResponse; // stores responses

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class API {
    private HttpClient client = HttpClient.newHttpClient();

    public JsonNode sendRequest(String url) {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url)) // adding a url for the request
            .GET() // request to obtain information
            .build(); // finalizes the build
        
        try {
            HttpResponse<String> response = this.client.send(request, HttpResponse.BodyHandlers.ofString()); // bodyhandlers.ofstring is what converts the response into a String
            if (response.statusCode() != 200) { // if the API request was unsuccessful.
                throw new RuntimeException("API returned " + response.statusCode());
            }
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readTree(response.body());
        } 
        catch (IOException | InterruptedException e) {
            throw new RuntimeException("Request failed: " + e.getMessage());
        }
    }

    public static String genURL(String barcode) {
        return "https://world.openfoodfacts.net/api/v2/product/" + barcode;
    }

    public static String genURL(String barcode, int setting) {
        switch (setting) {
            case 0 :
                return "https://world.openfoodfacts.net/api/v2/product/" + barcode;
            case 1 :
                return "https://world.openfoodfacts.net/api/v2/product/" + barcode + "?fields=product_name";
            default :
                return "https://world.openfoodfacts.net/api/v2/product/" + barcode;
        }
    }

    public static String genURL(String barcode, String fields) {
        return "https://world.openfoodfacts.net/api/v2/product/" + barcode + "?fields=" + fields;
    }
}

