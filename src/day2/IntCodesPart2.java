package day2;

import common.FileLoader;

import java.util.ArrayList;

public class IntCodesPart2 {
    public static void main(String[] args) {
        ArrayList<Integer> codeList = FileLoader.loadCommaFile("inputFiles/day2/input.txt");
        codeList.set(1, 12);
        codeList.set(2, 2);

        System.out.println(backTrackOpcode(codeList, 19690720).get(0));
    }

    public static ArrayList<Integer> backTrackOpcode(ArrayList<Integer> IntCode, int outputParamCheck) {
        System.out.println("Start Code" + IntCode);
        for (int i = 0; i < IntCode.size(); i += 4) {
            switch (IntCode.get(i)) {
                case 99:
                    break;
                case 1:
                    IntCode.set(IntCode.get(i + 3),
                            IntCode.get(IntCode.get(i + 1)) + IntCode.get(IntCode.get(i + 2)));
                    break;
                case 2:
                    IntCode.set(IntCode.get(i + 3),
                            IntCode.get(IntCode.get(i + 1)) * IntCode.get(IntCode.get(i + 2)));
                    break;
            }
            if (IntCode.get(i + 3) == outputParamCheck) getIntCodeValues(
                    IntCode.get(i + 1),
                    IntCode.get(i + 2));
        }
        System.out.println("End Code: " + IntCode);
        return IntCode;
    }

    private static void getIntCodeValues(int param1, int param2) {
        System.out.println("Noun: " + param1);
        System.out.println("Verb: " + param2);
        System.out.println("100 * " + param1 + " + " + param2);
        System.out.println(100 * param1 * param2);
    }
}
