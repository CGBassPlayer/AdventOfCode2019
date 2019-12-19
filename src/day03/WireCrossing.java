package day03;

import common.FileLoader;

import java.io.*;
import java.util.ArrayList;

public class WireCrossing {
    public static void main(String[] args) {
        System.out.println("Wire A");
        ArrayList<int[]> wireAPositions = getWirePositions(FileLoader.loadSingleLineCommaStringFile("inputfiles/day03Tom.dat", 1));
        //ArrayList<int[]> wireBPositions = getWirePositions(FileLoader.loadSingleLineCommaStringFile("inputfiles/day03.dat", 2));



        try {
            // Write ArrayList to log file for testing
            PrintWriter writer = new PrintWriter("Day03.log", "UTF-8");
            writer.println("x, y");
            for (int[] wireAPosition : wireAPositions) {
//                System.out.println(wireAPosition[0] + ", " + wireAPosition[1]);
                writer.println(wireAPosition[0] + ", " + wireAPosition[1]);
            }
            writer.close();
//            // Get Console output
//            PrintStream out = new PrintStream(
//                    new FileOutputStream("Day03.log", true), true);
//            System.setOut(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                    System.out.println("Up " + s.substring(1));
                    for (int i = size; i < Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[]{tempPos.get(i)[0], (tempPos.get(i)[1] + 1)});
                    }
                    break;
                case 'D':
                    System.out.println("Down " + s.substring(1));
                    for (int i = size; i < Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[]{tempPos.get(i)[0], (tempPos.get(i)[1] - 1)});
                    }
                    break;
                case 'L':
                    System.out.println("Left " + s.substring(1));
                    for (int i = size; i < Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[]{tempPos.get(i)[0] + 1, (tempPos.get(i)[1])});
                    }
                    break;
                case 'R':
                    System.out.println("Right " + s.substring(1));
                    for (int i = size; i < Integer.parseInt(s.substring(1)); i++) {
                        tempPos.add(new int[]{tempPos.get(i)[0] - 1, (tempPos.get(i)[1])});
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
}
