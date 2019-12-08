package day2;

import java.util.ArrayList;

import static common.FileLoader.loadCommaFile;

public class OpcodesPart2 {
    public static void main(String[] args) {
        ArrayList<Integer> codeList = loadCommaFile("inputFiles/day2/inputpart.txt");
        codeList.set(1, 12);
        codeList.set(2, 2);

        System.out.println(backTrackOpcode(codeList).get(0));
    }

    public static ArrayList<Integer> backTrackOpcode(ArrayList<Integer> opcode) {
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
