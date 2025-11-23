package gic.ryan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    @Test
    void testAddCar() {
        Field field = new Field(10, 10);
        Car car = new Car("A", 1, 2, Direction.N, "F");
        field.addCar(car);
        assertEquals(1, field.getCars().size());
    }

    @Test
    void testRunSimulation() {
        Field field = new Field(10, 10);
        Car carA = new Car("A", 1, 2, Direction.N, "FFRFF");
        Car carB = new Car("B", 3, 3, Direction.W, "FFLFF");
        field.addCar(carA);
        field.addCar(carB);
        field.runSimulation();

        System.out.println("Car A Position: (" + carA.getX() + ", " + carA.getY() + ") Direction: " + carA.getDirection());
        System.out.println("Car B Position: (" + carB.getX() + ", " + carB.getY() + ") Direction: " + carB.getDirection());

        // Correct the expected values based on the movements
        assertEquals(3, carA.getX());
        assertEquals(4, carA.getY());
        assertEquals(Direction.E, carA.getDirection());

        assertEquals(1, carB.getX());
        assertEquals(1, carB.getY());
        assertEquals(Direction.S, carB.getDirection());
    }
}
