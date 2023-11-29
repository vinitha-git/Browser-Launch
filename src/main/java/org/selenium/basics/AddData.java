package org.selenium.basics;

import java.util.ArrayList;
import java.util.List;

public class AddData {
    public List<String> addValue(){
        List<String> vegetables= new ArrayList<>();
        vegetables.add("Brinjal");
        vegetables.add("Keera");
        vegetables.add("Cucumber");
        vegetables.add("Tomato");

        return vegetables;

    }

    public static void main(String[] args) {
        AddData data = new AddData();
        List<String> veg = data.addValue();
        System.out.println("ArrayList: " +veg);
        System.out.println("No:of Vegetables: " + veg.size());
    }
}
