package src.easy;


import src.domain.Purchase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * src.easy.E13: Group purchases by year, and for each year group by users. output should be (year,user,List<purchase>) or Map<Integer,Map<String,List<Purchase>>>
 * */

public class E13 {
    // peek the maximum purchase item , or , Map<Integer,Map<String,Purchase>>
    // sol 1
    private static void solveForList2(List<Purchase> itemsList) {
        itemsList.stream().collect(
                Collectors.groupingBy(
                        Purchase::getYear,
                        Collectors.groupingBy(
                                Purchase::getUserId,
                                Collectors.maxBy(Comparator.comparingDouble(Purchase::getPrice))
                        )

                )
        ).forEach((key, value) -> System.out.println(key + " " + value));
    }

    // sol 2
    private static void solveForList3(List<Purchase> itemsList) {
        itemsList.stream().collect(
                Collectors.groupingBy(
                        Purchase::getYear,
                        Collectors.groupingBy(
                                Purchase::getUserId,
                                Collectors.maxBy(Comparator.comparingDouble(Purchase::getPrice))
                        )

                )
        ).forEach((key, value) -> System.out.println(key + " " + value));
    }

    private static void solveForList(List<Purchase> itemsList) {
        itemsList.stream().collect(
                Collectors.groupingBy(
                        Purchase::getYear,
                        Collectors.groupingBy(
                                Purchase::getUserId
                        )

                )
        ).forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static void main(String[] args) {
        Purchase[] itemsArray = {
                new Purchase("User1", "ItemA", 2022, 50.0),
                new Purchase("User1", "ItemA", 2022, 70.0),
                new Purchase("User2", "ItemB", 2021, 30.0),
                new Purchase("User3", "ItemC", 2022, 25.0),
                new Purchase("User1", "ItemD", 2021, 40.0),
                new Purchase("User1", "ItemD", 2021, 90.0),
                // Add more sample data as needed
        };
        List<Purchase> itemsList = Arrays.asList(itemsArray);
        solveForList(itemsList);
        solveForList2(itemsList);
    }
}
