package src.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * src.easy.E07: Convert a list/array of strings to uppercase.
 * */

public class E07 {
    private static void solveForArray(String[] itemsArray) {
        List<String> ansA = Stream.of(itemsArray).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("ansA " + ansA);
    }

    private static void solveForList(List<String> itemsList) {
        List<String> ansL = itemsList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("ansL " + ansL);
    }

    public static void main(String[] args) {
        String[] itemsArray = new String[]{"aba", "abb", "abc", "ddd"};
        solveForArray(itemsArray);
        List<String> itemsList = Arrays.asList("aba", "abb", "abc", "ddd");
        solveForList(itemsList);
    }
}
