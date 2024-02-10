package src.easy;

import domain.Purchase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/*
 * src.easy.E11: find the highest purchase in the list, if there is a tie take the latest by year.
 * */

public class E11 {

    private static void solveForList( List<Purchase> itemsList) {
        Optional<Purchase> optionalPurchase = itemsList.stream()
                .max(Comparator.comparingDouble(Purchase::getPrice).
                        thenComparing(Comparator.comparingInt(Purchase::getYear).reversed())
                );
        if(optionalPurchase.isPresent()){
            System.out.println(optionalPurchase.get());
        }else{
            System.out.println("missing");
        }

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
