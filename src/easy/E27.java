package src.easy;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * src.easy.E27: Check if all strings in a list/array are palindrome.
 * */

public class E27 {


    private static void solveForList(List<String> itemsList) {
        boolean b = itemsList.stream().allMatch(s->isPalindrome(s,0,s.length()-1));
        System.out.println(b);

    }

    private static boolean isPalindrome(String s, int st, int ed) {
        return st>=ed || (s.charAt(st)==s.charAt(ed) && isPalindrome(s,st+1,ed-1));
    }

    public static void main(String[] args) {
        List<String> itemsList = Arrays.asList("ada", "madam", "a");
        solveForList(itemsList);
        List<String> itemsList2 = Arrays.asList("adax", "madam", "a");
        solveForList(itemsList2);
    }
}
