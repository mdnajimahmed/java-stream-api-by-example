package src.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * src.easy.E02: Filter out the even numbers from a array/list.
 * */
public class E02 {
    public static void main(String[] args) {
        int[] numbersArray = new int[]{5, 1, 2, 3, 2, 3};
        int[] evenNumberArrays = IntStream.of(numbersArray).filter(i -> i % 2 == 0).toArray();
        System.out.println("evenNumberArrays = " + Arrays.toString(evenNumberArrays));
        List<Integer> numbersList = Arrays.asList(5, 1, 2, 3, 2, 3);
        List<Integer> evenNumbersList = numbersList.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("evenNumbersList = " + evenNumbersList);
    }
}
