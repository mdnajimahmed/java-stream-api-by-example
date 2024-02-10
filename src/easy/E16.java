package src.easy;

import domain.Purchase;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * src.easy.E16: Partition a list/array of integers into even and odd numbers.
 * */

public class E16 {




    private static void solveForList(List<Integer> itemsList) {
        itemsList.stream().collect(Collectors.partitioningBy(i->i%2==1))
                .forEach((k, v )-> System.out.println(k + " " + v));

    }

    public static void main(String[] args) {

        List<Integer> itemsList = Arrays.asList(1,2,3,4);
        solveForList(itemsList);
    }
}
