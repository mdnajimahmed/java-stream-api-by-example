package src.easy;


import src.domain.Purchase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * src.easy.E12: Concatenate all strings in a list/array into a single string.
 * */

public class E12 {

    private static void solveForList(List<Purchase> itemsList) {
        String users = itemsList.stream().map(Purchase::getUserId).distinct().collect(Collectors.joining(","));
        System.out.println(users);

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
