package src.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * src.easy.E29: Find the difference between the largest and smallest numbers in a list/array.
 * */

public class E29 {


    private static void solveForList(List<Integer> itemsList) {
        itemsList.stream().max(Comparator.naturalOrder()).
                flatMap(max->itemsList.stream().map(i->max-i).max(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

    }



    public static void main(String[] args) {
        List<Integer> itemsList = Arrays.asList(1,2,3,4,5);
        solveForList(itemsList);
    }
}
