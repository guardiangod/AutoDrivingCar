package gic.ryan;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void testTurnLeft() {
        Car car = new Car("A", 1, 2, Direction.N, "L");
        car.executeNextCommand(10, 10);
        assertEquals(Direction.W, car.getDirection());
    }

    @Test
    void testTurnRight() {
        Car car = new Car("A", 1, 2, Direction.N, "R");
        car.executeNextCommand(10, 10);
        assertEquals(Direction.E, car.getDirection());
    }

    @Test
    void testMoveForward() {
        Car car = new Car("A", 1, 2, Direction.N, "F");
        car.executeNextCommand(10, 10);
        assertEquals(3, car.getY());
    }
}
