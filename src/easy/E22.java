package src.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * src.easy.E22: Sort a list/array of strings by their length.
 * */

public class E22 {


    private static void solveForList(List<String> itemsList) {
        itemsList.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

    }

    public static void main(String[] args) {
        List<String> itemsList = Arrays.asList("najim", "ehan", "Mahmuda");
        solveForList(itemsList);
    }
}
