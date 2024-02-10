package src.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * src.easy.E30: Sort a list/array of strings by their last character.
 * */

public class E30 {


    private static void solveForList(List<String> itemsList) {
        itemsList.stream().sorted(Comparator.comparing(s -> s.charAt(s.length() - 1)))
                .forEach(System.out::println);
    }


    public static void main(String[] args) {
        List<String> itemsList = Arrays.asList("havoc", "kebab", "ada");
        solveForList(itemsList);
    }
}
