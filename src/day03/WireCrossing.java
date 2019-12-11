package day03;

import common.FileLoader;

import java.util.ArrayList;

public class WireCrossing {
    public static void main(String[] args) {
        ArrayList<String> wireADirections = FileLoader.loadSingleLineCommaStringFile("inputFiles/day03/day01.elf", 1);
        ArrayList<String> wireBDirections = FileLoader.loadSingleLineCommaStringFile("inputFiles/day03/day01.elf", 2);

        findClosestCrossing(wireADirections, wireBDirections);
    }

    public static void findClosestCrossing(ArrayList<String> wireA, ArrayList<String> wireB) {
        ArrayList<int[]> wireAPositions = new ArrayList<>();
        ArrayList<int[]> tempPos = new ArrayList<>();
        ArrayList<int[]> wireBPositions = new ArrayList<>();
        tempPos.add(new int[] {0, 0});

        // Get all coordinates of
        for (String s : wireA) {
            switch (s.charAt(0)) {
                case 'U':
                    for (int i = wireAPositions.size(); i < wireAPositions.size() + Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[] {tempPos.get(i)[0], (tempPos.get(i)[1] + 1)});
                    }
                    break;
                case 'D':
                    for (int i = wireAPositions.size(); i < wireAPositions.size() + Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[] {tempPos.get(i)[0], (tempPos.get(i)[1] - 1)});
                    }
                    break;
                case 'L':
                    for (int i = wireAPositions.size(); i < wireAPositions.size() + Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[] {tempPos.get(i)[0] + 1, (tempPos.get(i)[1])});
                    }
                    break;
                case 'R':
                    for (int i = wireAPositions.size(); i < wireAPositions.size() + Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[] {tempPos.get(i)[0] - 1, (tempPos.get(i)[1])});
                    }
                    break;
            }
        }

        wireAPositions.addAll(tempPos);
        for (int[] wireAPosition : wireAPositions) {
            System.out.println(wireAPosition[0] + ", " + wireAPosition[1]);
        }
    }
}
