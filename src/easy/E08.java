package src.easy;

import domain.Purchase;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * src.easy.E08: Given a list of purchase(user,item,year,price). Find the most expensive item purchased
 * by each user for each year. In other words, find distinct item by (year,user,item) and if
 * there is a tie take to one for which price is the highest.
 * */

public class E08 {
    private static void solveForList(List<Purchase> itemsList) {

        itemsList.stream()
                .collect(
                        Collectors.toMap(
                                // keyMapper
                                purchase -> String.format("%d#%s#%s", purchase.getYear(),  purchase.getUserId(),purchase.getItemId()),
                                // ValueMapper
                                Function.identity(),
                                // merge function
                                BinaryOperator.maxBy(Comparator.comparing(Purchase::getPrice)),
                                TreeMap::new  // Specify TreeMap for sorting
                        )).forEach((key, value) -> System.out.println(key + " " + value));

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
