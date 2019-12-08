package day2;

import java.util.ArrayList;

import static common.FileLoader.loadCommaFile;

public class Opcodes {
    public static void main(String[] args) {
        ArrayList<Integer> code = loadCommaFile("inputFiles/day2/input.txt");
        code.set(1, 12);
        code.set(2, 2);

        System.out.println(runOpcode(code).get(0));
    }

    /**
     * Process Intcodes as specified at https://adventofcode.com/2019/day/2
     *
     * @param opcode ArrayList of opcodes to be processed
     * @return ArrayList of opcodes after they have been matched
     */
    public static ArrayList<Integer> runOpcode(ArrayList<Integer> opcode) {
        System.out.println("Start Code" + opcode);
        for (int i = 0; i < opcode.size(); i += 4) {
            switch (opcode.get(i)) {
                case 99:
                    break;
                case 1:
                    opcode.set(opcode.get(i + 3),
                            opcode.get(opcode.get(i + 1)) + opcode.get(opcode.get(i + 2)));
                    break;
                case 2:
                    opcode.set(opcode.get(i + 3),
                            opcode.get(opcode.get(i + 1)) * opcode.get(opcode.get(i + 2)));
                    break;
            }
        }
        System.out.println("End Code: " + opcode);
        return opcode;
    }
}
