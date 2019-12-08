package day1;

import common.FileLoader;

import java.util.ArrayList;

import static day1.RocketEquation.calculateFuel;

public class RocketEquationPart2 {
    public static void main(String[] args) {
        // Get Ship List
        ArrayList<Integer> rocketMass = FileLoader.loadNewLineFile("inputFiles/day1/input.txt");
        int totalFuel = 0;

        for (Integer mass : rocketMass) {
            int fuel = calculateFuel(mass);
            while (Math.floor(fuel) >= 0) {
                totalFuel += fuel;
                fuel = calculateFuel(fuel);
                if (fuel < 0) {
                    break;
                }
            }
        }

        System.out.println("Total Fuel Required: " + totalFuel);
    }
}
