package src.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
 * src.easy.E16: Find the second-smallest number in a list/array.
 * */

public class E19 {


    private static void solveForList(List<Integer> itemsList) {
        itemsList.stream().min(Comparator.naturalOrder())
                .flatMap(min->itemsList.stream().filter(i->i>min).min(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

    }

    public static void main(String[] args) {

        List<Integer> itemsList = Arrays.asList(1, 2, 3, 4);
        solveForList(itemsList);
        List<Integer> itemsList2 = Arrays.asList(1,1,1,1);
        solveForList(itemsList2);
    }
}
