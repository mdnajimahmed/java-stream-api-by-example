package src.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * src.easy.E21: Calculate the sum of the squares of all even numbers in a list/array.
 * */

public class E21 {


    private static void solveForList(List<Integer> itemsList) {
        itemsList.stream().filter(i->i%2==0)
                .map(i->i*i)
                .reduce(Integer::sum).ifPresent(System.out::println);

    }

    public static void main(String[] args) {
        List<Integer> itemsList = Arrays.asList(1, 2, 3, 4);
        solveForList(itemsList);
    }
}
