package day04;

import common.FileLoader;

import java.util.ArrayList;

public class SecureContainerPart2 {
    public static void main(String[] args) {
        ArrayList<Integer> range = FileLoader.loadNewLineIntFile("inputfiles/day04.dat");
        ArrayList<Integer> solutions = getPossibleSolutions(range.get(0), range.get(1));
        System.out.println("Total possible passwords: " + solutions.size());
    }

    public static ArrayList<Integer> getPossibleSolutions(int low, int high) {
        ArrayList<Integer> totalPasswords = new ArrayList<>();
        for (int i = low; i < high; i++) {
            if (SecureContainer.hasAscendingDigits(i) && SecureContainer.containsADouble(i) && hasDoubles(i)) {
                System.out.println(i);
                totalPasswords.add(i);
            }
        }
        return totalPasswords;
    }

    public static boolean hasDoubles(int number) {
        String num = String.valueOf(number);
        for (int i = 1; i < num.length() - 1; i++) {
            int preDigit = Character.digit(num.charAt(i - 1), 10);
            int digit = Character.digit(num.charAt(i), 10);
            int postDigit = Character.digit(num.charAt(i + 1), 10);

            if (preDigit == digit && digit == postDigit) {
                return false;
            }
        }
        return true;
    }
}
