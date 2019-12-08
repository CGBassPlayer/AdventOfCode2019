package day2;

import common.FileLoader;

import java.util.ArrayList;

public class IntCodes {
    public static void main(String[] args) {
        ArrayList<Integer> code = FileLoader.loadCommaFile("inputFiles/day2/input.txt");
        code.set(1, 12);
        code.set(2, 2);

        System.out.println(runOpcode(code).get(0));
    }

    /**
     * Process Intcodes as specified at https://adventofcode.com/2019/day/2
     *
     * @param IntCode ArrayList of opcodes to be processed
     * @return ArrayList of opcodes after they have been matched
     */
    public static ArrayList<Integer> runOpcode(ArrayList<Integer> IntCode) {
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
        }
        System.out.println("End Code: " + IntCode);
        return IntCode;
    }
}
