package src;

import src.domain.Purchase;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomCollectorExample {
    public static void main(String[] args) {
        Purchase[] itemsArray = {
                new Purchase("User1", "ItemA", 2022, 50.0),
                new Purchase("User1", "ItemA", 2022, 150.0),
                new Purchase("User1", "ItemA", 2022, 70.0),
                new Purchase("User2", "ItemB", 2021, 30.0),
                new Purchase("User3", "ItemC", 2022, 25.0),
                new Purchase("User1", "ItemD", 2021, 40.0),
                new Purchase("User1", "ItemD", 2021, 60.0),
                new Purchase("User1", "ItemD", 2021, 130.0),
                new Purchase("User1", "ItemD", 2021, 90.0),
                // Add more sample data as needed
        };
        List<Purchase> itemsList = Arrays.asList(itemsArray);
        playExample1Easy(itemsList);
        playExample2Hard(itemsList);

    }

    private static void playExample2Hard(List<Purchase> itemsList) {
        // group by year, for each group take only those prices between [ 50,100] , drop others


        Supplier<Map<Integer, List<Purchase>>> supplier = HashMap::new;

        BiConsumer<Map<Integer, List<Purchase>>, Purchase> accumulator = (map, item) -> map.compute(item.getYear(), (key, val) -> {

            if (val == null) {
                val = new ArrayList<>();
            }
            if (item.getPrice() >= 50 && item.getPrice() <= 100) {
                val.add(item);
            }
            return val;
        });

        BinaryOperator<Map<Integer, List<Purchase>>> combiner = (m1, m2) -> {
            // Create a new map to avoid modifying the existing maps
            Map<Integer, List<Purchase>> result = new HashMap<>(m1);

            // Merge values from map2 into result
            m2.forEach((key, value) -> result.merge(key, value, (l1, l2) -> {
                l1.addAll(l2);
                return l1;
            }));

            return result;
        };


        // Fix the accumulator to create a new sum instead of modifying the existing one
        Collector<Purchase, Map<Integer, List<Purchase>>, Map<Integer, List<Purchase>>> myCollector = Collector.of(
                supplier,
                accumulator,
                combiner
        );

        Map<Integer, List<Purchase>> myResult = itemsList.stream().collect(myCollector);
        myResult.entrySet().forEach(System.out::println);


    }

    private static void playExample1Easy(List<Purchase> itemsList) {
        // group by year, for each group take the total of purchase


        Supplier<Map<Integer, Double>> supplier = HashMap::new;

        BiConsumer<Map<Integer, Double>, Purchase> accumulator = (map, item) -> map.compute(item.getYear(), (key, val) -> val != null ? item.getPrice() + val : item.getPrice());

        BinaryOperator<Map<Integer, Double>> combiner = (m1, m2) -> {
            // Create a new map to avoid modifying the existing maps
            Map<Integer, Double> result = new HashMap<>(m1);

            // Merge values from map2 into result
            m2.forEach((key, value) -> result.merge(key, value, Double::sum));

            return result;
        };


        // Fix the accumulator to create a new sum instead of modifying the existing one
        Collector<Purchase, Map<Integer, Double>, Map<Integer, Double>> myCollector = Collector.of(
                supplier,
                accumulator,
                combiner
        );

        Map<Integer, Double> myResult = itemsList.stream().collect(myCollector);
        myResult.entrySet().forEach(System.out::println);

    }
}
