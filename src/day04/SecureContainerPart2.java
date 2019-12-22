package day04;

import common.FileLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SecureContainerPart2.java
 *
 * @author Ryan Goodwin on 12/22/2019.
 */
public class SecureContainerPart2 {
    public static void main(String[] args) {
        ArrayList<Integer> range = FileLoader.loadNewLineIntFile("inputfiles/day04.dat");
        ArrayList<Integer> solutions = getPossibleSolutions(range.get(0), range.get(1));
        System.out.println("Total possible passwords: " + solutions.size());
    }

    public static ArrayList<Integer> getPossibleSolutions(int low, int high) {
        ArrayList<Integer> totalPasswords = new ArrayList<>();
        for (int i = low; i < high; i++) {
            if (SecureContainer.hasAscendingDigits(i) && SecureContainer.contiansDoubles(i) && hasDoubles(i)) {
                System.out.println(i);
                totalPasswords.add(i);
            }
        }
        return totalPasswords;
    }

    private static boolean hasDoubles(int number) {
        String[] digits = String.valueOf(number)
                .split("");

        Arrays.stream(digits)
                .collect(Collectors.groupingBy(s -> s))
                .forEach((k, v) -> System.out.println(number + ": " + v.size() + " occurrences of " + k));

        return false;


//        boolean foundDouble = false;
//        int doubleFound = -1;
//        String num = String.valueOf(number);
//        for (int i = 1; i < num.length() - 1; i++) {
//            int preDigit = Character.digit(num.charAt(i - 1), 10);
//            int digit = Character.digit(num.charAt(i), 10);
//            int postDigit = Character.digit(num.charAt(i + 1), 10);
//
//            if(i != 1 && doubleFound != -1) {
//                //if (!containsTriple(number)) {
//                    foundDouble = true;
//                //}
//            }
//
//            if ((preDigit == digit && digit != postDigit ) || ( preDigit != digit &&  digit == postDigit)) {
//                doubleFound = digit;
//            }
//        }
//        return foundDouble;
    }

//    private static boolean containsTriple(int number){
//        boolean tripleFound = false;
//        String num = String.valueOf(number);
//        for (int i = 1; i < num.length() - 1; i++) {
//            int preDigit = Character.digit(num.charAt(i - 1), 10);
//            int digit = Character.digit(num.charAt(i), 10);
//            int postDigit = Character.digit(num.charAt(i + 1), 10);
//
//            if(preDigit == digit && digit == postDigit){
//                tripleFound = true;
//            }
//        }
//        return tripleFound;
//    }
}
