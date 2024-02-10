package src.src.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// takewhile, unorderd,allmatch,anymatch,nonematch,
/*
 * src.easy.E01: Find the sum of all numbers in a array/list.
 * */
public class E01 {
    public static void main(String[] args) {
        int[] numbersArray = new int[]{5, 1, 2, 3, 2, 3};
        int sumArray = IntStream.of(numbersArray).sum();
        System.out.println("sumArray = " + sumArray);
        List<Integer> numbersList = Arrays.asList(5, 1, 2, 3, 2, 3);
        Integer sumList = numbersList.stream().reduce(0, Integer::sum);
        System.out.println("sumList = " + sumList);

        /*
        int sum = IntStream.of(numbers)
                .takeWhile(x -> x%2==1)
                .dropWhile(x -> x > 3)
                .distinct().peek(System.out::println).sum();
        System.out.println(sum);

        boolean b = IntStream.of(numbers).allMatch(x -> x < 30);
        System.out.println(b);

        boolean c = IntStream.of(numbers).anyMatch(x -> x < 3);
        System.out.println(c);

        boolean d = IntStream.of(numbers).noneMatch(x -> x < 0);
        System.out.println(d);
         */
    }
}
