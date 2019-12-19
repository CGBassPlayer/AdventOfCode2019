package day03;

import common.FileLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WireCrossing {
    public static void main(String[] args) {
        ArrayList<int[]> wireAPositions = getWirePositions(FileLoader.loadSingleLineCommaStringFile("inputfiles/day03.dat", 1));
        ArrayList<int[]> wireBPositions = getWirePositions(FileLoader.loadSingleLineCommaStringFile("inputfiles/day03.dat", 2));

//        // Write ArrayLists to log file for testing
//        try {
//            PrintWriter writer = new PrintWriter("logs/Day03.log", "UTF-8");
//            writer.println("x, y");
//            writer.println("Wire A");
//            for (int[] wireAPosition : wireAPositions) {
//                writer.println(wireAPosition[0] + ", " + wireAPosition[1]);
//            }
//            writer.println("Wire B");
//            for (int[] wireBPosition : wireBPositions) {
//                writer.println(wireBPosition[0] + ", " + wireBPosition[1]);
//            }
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ArrayList<Integer> distances = getDistances(findAllCrossings(wireAPositions, wireBPositions));

        System.out.println("Shortest distance: " + Collections.min(distances));
    }

    public static ArrayList<int[]> getWirePositions(ArrayList<String> wire) {
        ArrayList<int[]> wirePositions = new ArrayList<>();
        ArrayList<int[]> tempPos = new ArrayList<>();
        tempPos.add(new int[]{0, 0});
        int size;

        // Get all coordinates of
        for (String s : wire) {
            size = Math.max(tempPos.size() - 1, 0);

            switch (s.charAt(0)) {
                case 'U':
                    //System.out.println("Up " + s.substring(1));
                    for (int i = size; i < Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[]{tempPos.get(i)[0], (tempPos.get(i)[1] + 1)});
                    }
                    break;
                case 'D':
                    //System.out.println("Down " + s.substring(1));
                    for (int i = size; i < Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[]{tempPos.get(i)[0], (tempPos.get(i)[1] - 1)});
                    }
                    break;
                case 'L':
                    //System.out.println("Left " + s.substring(1));
                    for (int i = size; i < Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[]{tempPos.get(i)[0] - 1, (tempPos.get(i)[1])});
                    }
                    break;
                case 'R':
                    //System.out.println("Right " + s.substring(1));
                    for (int i = size; i < Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[]{tempPos.get(i)[0] + 1, (tempPos.get(i)[1])});
                    }
                    break;
            }

            for (int[] coords : tempPos) {
                wirePositions.add(new int[]{coords[0], coords[1]});
            }
            tempPos.clear();
            tempPos.add(new int[]{wirePositions.get(wirePositions.size() - 1)[0], wirePositions.get(wirePositions.size() - 1)[1]});
        }

        return wirePositions;
    }

    public static ArrayList<int[]> findAllCrossings(ArrayList<int[]> wireA, ArrayList<int[]> wireB) {
        ArrayList<int[]> crossingPoints = new ArrayList<>();
        for (int[] a : wireA) {
            if (a[0] != 0 && a[1] != 0) {
                for (int[] b : wireB) {
                    if (a[0] == b[0] && a[1] == b[1]) {
                        crossingPoints.add(new int[]{a[0], a[1]});
                    }
                }
            }
        }
        return crossingPoints;
    }

    public static ArrayList<Integer> getDistances(ArrayList<int[]> crossings) {
        ArrayList<Integer> distances = new ArrayList<>();
        for (int[] crossing : crossings) {
            distances.add(Math.abs(crossing[0]) + Math.abs(crossing[1]));
        }
        return distances;
    }
}
