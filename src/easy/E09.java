package src.easy;

import domain.Purchase;

import java.util.*;

/*
 * src.easy.E09: Sort a list/array of purchases by year, if same year sort by price descending
 * */

public class E09 {

    private static void solveForList( List<Purchase> itemsList) {
        itemsList.stream().sorted(
                Comparator
                        .comparingInt(Purchase::getYear)
                        .thenComparing(Comparator.comparingDouble(Purchase::getPrice).reversed())
        ).forEach(System.out::println);
    }

    public static void main(String[] args) {
        Purchase[] itemsArray = {
                new Purchase("User1", "ItemA", 2022, 50.0),
                new Purchase("User2", "ItemB", 2021, 30.0),
                new Purchase("User3", "ItemC", 2022, 25.0),
                new Purchase("User1", "ItemD", 2021, 40.0),
                // Add more sample data as needed
        };
        List<Purchase> itemsList = Arrays.asList(itemsArray);
        solveForList(itemsList);
    }
}
