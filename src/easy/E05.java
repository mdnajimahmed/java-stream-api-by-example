package src.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * src.easy.E05: Check if all elements in a list/array are greater than 10.
 * */

public class E05 {
    private static void solveForArray(int[] numbersArray) {
        boolean isAllGreaterThan10Array = IntStream.of(numbersArray).
                allMatch(i -> i > 10);
        System.out.println("isAllGreaterThan10Array = " + isAllGreaterThan10Array);

    }

    private static void solveForList(List<Integer> numbersList) {
        boolean isAllGreaterThan10List = numbersList.stream().allMatch(i->i>10);
        System.out.println("isAllGreaterThan10List = " + isAllGreaterThan10List);
    }

    public static void main(String[] args) {
        int[] numbersArray = new int[]{5, 1, 2, 3, 2, 3};
        solveForArray(numbersArray);
        int[] numbersArray2 = new int[]{11,12};
        solveForArray(numbersArray2);
        List<Integer> numbersList = Arrays.asList(11,12);
        solveForList(numbersList);
    }
}
