package gic.ryan;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private int width;
    private int height;
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.cars = new ArrayList<>();
    }

    /** Add a car to the field */
    public void addCar(Car car) {
        if (car.getX() >= 0 && car.getX() < width && car.getY() >= 0 && car.getY() < height) {
            cars.add(car);
            System.out.println("Car " + car.getName() + " added at position (" + car.getX() + "," + car.getY() + ") facing " + car.getDirection());
        } else {
            System.out.println("Car " + car.getName() + " is out of bounds and cannot be added.");
        }
    }

    /** Print car positions before simulation */
    public void printCurrentCars() {
        System.out.println("\nYour current list of cars are:");
        for (Car car : cars) {
            System.out.println("- " + car.getName() + ", (" + car.getX() + "," + car.getY() + ") " + car.getDirection() + ", " + car.getCommands());
        }
    }

    public void runSimulation() {
        boolean collisionOccurred = false;
        while (true) {
            boolean allCommandsExecuted = true;
            for (Car car : cars) {
                if (car.hasMoreCommands() && !car.isCollided()) {
                    car.executeNextCommand(width, height);
                    allCommandsExecuted = false;
                    if (checkForCollision(car)) {
                        collisionOccurred = true;
                        break;
                    }
                }
            }
            if (allCommandsExecuted || collisionOccurred) {
                break;
            }
        }
    }

    private boolean checkForCollision(Car car) {
        for (Car otherCar : cars) {
            if (!car.equals(otherCar) && car.getX() == otherCar.getX() && car.getY() == otherCar.getY()) {
                car.collide(otherCar.getName());
                otherCar.collide(car.getName());
                return true;
            }
        }
        return false;
    }

    /** Print car positions after simulation */
    public void printResults() {
        System.out.println("\nAfter simulation, the result is:");
        for (Car car : cars) {
            if (car.isCollided()) {
                // A bit of a brain hack here: step = commandIndex + 1
                // because step 0 is the initial position of the car
                System.out.println("- " + car.getName() + ", collides with " + car.getCollidedWith() + " at (" + car.getX() + ", "+ car.getY() + ") at step " + (car.getCommandIndex()+1));
            }
            else {
                System.out.println("- " + car.getName() + ", (" + car.getX() + "," + car.getY() + ") " + car.getDirection());
            }
        }
    }
}
