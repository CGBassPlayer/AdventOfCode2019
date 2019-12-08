package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Opcodes {
    public static void main(String[] args) {
        ArrayList<Integer> code;
        code = loadFile("inputFiles/day2/input.txt");
        code.set(1, 12);
        code.set(2, 2);

        System.out.println(runOpcode(code));
    }

    private static int runOpcode(ArrayList<Integer> opcode) {
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
        return opcode.get(0);
    }

    private static ArrayList<Integer> loadFile(String path) {
        ArrayList<Integer> codeList = new ArrayList<>();
        String bigToke;
        String[] tokens;

        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            while ((bigToke = in.readLine()) != null) {
                for (int i = 0; i < (tokens = bigToke.split(",")).length; i++) {
                    codeList.add(Integer.parseInt(tokens[i]));
                }
            }
        } catch (IOException e) {
            System.err.println("Failed to load File");
            e.printStackTrace();
        }

        return codeList;
    }
}
