package src.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * src.easy.E03: Double each element in a list/array.
 * */
public class E03 {
    public static void main(String[] args) {
        int[] numbersArray = new int[]{5, 1, 2, 3, 2, 3};
        int[] squaredNumbers = IntStream.of(numbersArray).
        map(i->i*i).toArray();
        System.out.println("squaredNumbers = " + Arrays.toString(squaredNumbers));
        List<Integer> numbersList = Arrays.asList(5, 1, 2, 3, 2, 3);
        List<Integer> squareNumbersList = numbersList.stream().map(i -> i *i).toList();
        System.out.println("squareNumbersList = " + squareNumbersList);
    }
}
