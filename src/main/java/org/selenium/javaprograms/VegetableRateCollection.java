package org.selenium.javaprograms;
import java.util.HashMap;
import java.util.Map;

public class VegetableRateCollection {
    public static void main(String[] args) {
        // Create a two-dimensional Map to store vegetable and rate information
        Map<String, Map<String, Double>> vegetableRates = new HashMap<>();

        // Adding vegetable rates
        addVegetableRate(vegetableRates, "Carrot", "USD", 1.5);
        addVegetableRate(vegetableRates, "Tomato", "USD", 2.0);
        addVegetableRate(vegetableRates, "Spinach", "USD", 1.0);

        // Retrieving and printing vegetable rates
        printVegetableRates(vegetableRates, "Carrot", "USD");
        printVegetableRates(vegetableRates, "Tomato", "USD");
        printVegetableRates(vegetableRates, "Spinach", "USD");
    }

    // Method to add vegetable rates to the collection
    private static void addVegetableRate(Map<String, Map<String, Double>> collection, String vegetable, String currency, double rate) {
        // Check if the vegetable is already in the collection
        if (!collection.containsKey(vegetable)) {
            collection.put(vegetable, new HashMap<>());
        }

        // Add the rate for the specified currency
        collection.get(vegetable).put(currency, rate);
    }

    // Method to print vegetable rates from the collection
    private static void printVegetableRates(Map<String, Map<String, Double>> collection, String vegetable, String currency) {
        // Check if the vegetable is in the collection
        if (collection.containsKey(vegetable)) {
            // Check if the rate for the specified currency is available
            if (collection.get(vegetable).containsKey(currency)) {
                double rate = collection.get(vegetable).get(currency);
                System.out.println("The rate of " + vegetable + " in " + currency + " is: " + rate);
            } else {
                System.out.println("Rate not available for " + vegetable + " in " + currency);
            }
        } else {
            System.out.println("Vegetable not found: " + vegetable);
        }
    }
}




