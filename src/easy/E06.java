package src.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * src.easy.E06: Count the number of strings in a list/array that start with a given prefix.
 * */

public class E06 {
    private static void solveForArray(String[] itemsArray, String prefix) {
        long countA = Stream.of(itemsArray).filter(item -> item.startsWith(prefix)).count();
        System.out.println("countA " + countA);
    }

    private static void solveForList(List<String> itemsList, String prefix) {
        long countL = itemsList.stream().filter(item -> item.startsWith(prefix)).count();
        System.out.println("countL " + countL);
    }

    public static void main(String[] args) {
        String[] itemsArray = new String[]{"aba", "abb", "abc", "ddd"};
        solveForArray(itemsArray,"ab");
        List<String> itemsList = Arrays.asList("aba", "abb", "abc", "ddd");
        solveForList(itemsList,"ab");
    }
}
