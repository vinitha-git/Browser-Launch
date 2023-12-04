package org.selenium.basics;

import java.util.ArrayList;
import java.util.List;

public class VegetablePriceCalculator {
    public static void main(String[] args) {
        // Create a list to store vegetable names and prices
        List<Vegetable> vegetableList = new ArrayList<>();

        // Add vegetables and their prices to the list
        vegetableList.add(new Vegetable("Carrot", 1.5));
        vegetableList.add(new Vegetable("Tomato", 2.0));
        vegetableList.add(new Vegetable("Spinach", 1.0));

        // Calculate the total price of vegetables
        double totalPrice = calculateTotalPrice(vegetableList);

        // Print the total price
        System.out.println("Total price of vegetables: " + totalPrice);
    }

    // Class representing a vegetable with name and price
    static class Vegetable {
        private String name;
        private  double price;

        public Vegetable(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    // Method to calculate the total price of vegetables in the list
    private static double calculateTotalPrice(List<Vegetable> vegetables) {
        double totalPrice = 0.0;

        // Iterate through the list and sum up the prices
        for (Vegetable vegetable : vegetables) {
            totalPrice += vegetable.getPrice();
        }

        return totalPrice;
    }
}
