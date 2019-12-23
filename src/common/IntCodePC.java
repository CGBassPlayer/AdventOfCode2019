package common;

import java.util.ArrayList;

public class IntCodePC {
    private final ArrayList<Integer> input;

    public IntCodePC(ArrayList<Integer> input) {
        this.input = input;
    }

    public ArrayList<Integer> runOpcode() {
        int parameters = 0;
        int index = 0;

        while (index < input.size()) {
            switch (input.get(index) % 100) {
                case 99:
                    break;
                case 1:
                    parameters = 3;
                    input.set(input.get(index + 3),
                            input.get(input.get(index + 1)) + input.get(input.get(index + 2)));
                    break;
                case 2:
                    parameters = 3;
                    input.set(input.get(index + 3),
                            input.get(input.get(index + 1)) * input.get(input.get(index + 2)));
                    break;
                case 3:
                    parameters = 1;
                    break;
                case 4:
                    parameters = 1;
                    break;
            }
            if (String.valueOf(input.get(index)).length() < 5) {
                switch (Integer.parseInt(Integer.toString(input.get(index)).substring(0, 1))) {

                }
            }

            index += parameters;
        }

        return new ArrayList<>();
    }
}
