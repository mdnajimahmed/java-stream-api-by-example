package src.easy;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

/*
 * src.easy.E04: Find the average of all numbers in a list/array.
 * */

public class E04 {
    private static void solveForArray(int[] numbersArray) {
        double averageOfArray = IntStream.of(numbersArray).
                average().orElse(0.0);
        System.out.println("averageOfArray = " + averageOfArray);

    }

    private static void solveForList(List<Integer> numbersList) {
        double averageOfList = numbersList.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        System.out.println("averageOfList = 2(n)" + averageOfList);

        Integer total = numbersList.stream().reduce(0, Integer::sum);
        double averageOfList2 = numbersList.isEmpty()? 0 : ((double) total / numbersList.size());
        System.out.println("averageOfList2 = o(n) " + averageOfList2);
    }

    public static void main(String[] args) {
        int[] numbersArray = new int[]{5, 1, 2, 3, 2, 3};
        solveForArray(numbersArray);
        List<Integer> numbersList = Arrays.asList(5, 1, 2, 3, 2, 3);
        solveForList(numbersList);
    }
}
