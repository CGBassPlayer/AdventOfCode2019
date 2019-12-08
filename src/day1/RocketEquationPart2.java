package day1;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;

public class RocketEquationPart2 {
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

        for (Integer mass : rocketMass) {
            int fuel = calculateFuel(mass);
            System.out.println("Mass Fuel: " + fuel);
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

    public static int calculateFuel(int mass) {
        return (int) Math.floor(mass / 3) - 2;
    }
}
