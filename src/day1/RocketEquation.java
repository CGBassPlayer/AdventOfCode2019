package day1;

import java.io.*;
import java.util.ArrayList;

public class RocketEquation {
    public static void main(String[] args) {
        // Get Ship List
        ArrayList<Integer> rocketMass = new ArrayList<>();
        File file = new File("inputFiles/day1/input.txt");
        int totalFuel = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String mass = null;

            while ((mass = reader.readLine()) != null) {
                rocketMass.add(Integer.parseInt(mass));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Integer mass : rocketMass) totalFuel += calculateFuel(mass);

        System.out.println("Total Fuel Required: " + totalFuel);
    }

    private static int calculateFuel(int mass) {
        return (int)Math.floor(mass /3) - 2;
    }
}
