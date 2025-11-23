package gic.ryan;

import java.util.Scanner;

public class AutoDrivingCarApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int option = 1;
            do {
                System.out.println("\nWelcome to Auto Driving Car Simulation!");
                System.out.println("Please enter the width and height of the simulation field in x y format:");

                int width = scanner.nextInt();
                int height = scanner.nextInt();
                Field field = new Field(width, height);

                System.out.println("You have created a field of " + width + " x " + height);
                while (true) {
                    System.out.println("\nPlease choose from the following options:");
                    System.out.println("[1] Add a car to field");
                    System.out.println("[2] Run simulation");
                    int choice = scanner.nextInt();

                    if (choice == 1) {
                        System.out.println("Please enter the name of the car:");
                        String name = scanner.next();
                        System.out.println("Please enter initial position of car " + name + " in x y Direction format:");
                        int x = scanner.nextInt();
                        int y = scanner.nextInt();
                        String direction = scanner.next();
                        System.out.println("Please enter the commands for car " + name);
                        String commands = scanner.next();
                        Car car = new Car(name, x, y, Direction.valueOf(direction), commands);
                        field.addCar(car);
                    }
                    else if (choice == 2) {
                        field.printCurrentCars();
                        field.runSimulation();
                        field.printResults();
                        break;
                    }
                    else {
                        System.out.println("Invalid option!");
                    }
                }

                // Offer options to start over or exit
                System.out.println("\nPlease choose from the following options:");
                System.out.println("[1] Start over");
                System.out.println("[2] Exit");
                option = scanner.nextInt();
            } while (option == 1);

            System.out.println("\nThank you for running the simulation. Goodbye!");
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            scanner.close();
        }
    }
}
