package day1;

import common.FileLoader;

import java.util.ArrayList;

public class RocketEquation {
    public static void main(String[] args) {
        ArrayList<Integer> rocketMass = FileLoader.loadNewLineFile("inputFiles/day1/input.txt");
        int totalFuel = 0;

        for (Integer mass : rocketMass) totalFuel += calculateFuel(mass);

        System.out.println("Total Fuel Required: " + totalFuel);
    }

    /**
     * Calculates required fuel for a given mass.
     *
     * @param mass Mass of the object
     * @return required mass of fuel
     */
    public static int calculateFuel(int mass) {
        return (int) Math.floor(mass / 3) - 2;
    }
}
