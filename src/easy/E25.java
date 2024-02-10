package src.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * src.easy.E25: Group a list/array of words by their length.
 * */

public class E25 {


    private static void solveForList(List<String> itemsList) {
        itemsList.stream().collect(Collectors.groupingBy(String::length)).forEach((k, v) -> System.out.println(k + " " + v));

    }

    public static void main(String[] args) {
        List<String> itemsList = Arrays.asList("najim", "ehan", "Mahmuda");
        solveForList(itemsList);
    }
}
