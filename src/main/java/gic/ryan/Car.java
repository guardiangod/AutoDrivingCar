package gic.ryan;

public class Car {
    private String name;
    private int x;
    private int y;
    private Direction direction;
    private String commands;
    private int commandIndex;
    private boolean collided;
    private String collidedWith;

    public Car(String name, int x, int y, Direction direction, String commands) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.commands = commands;
        this.commandIndex = 0;
        this.collided = false;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getCommands() {
        return commands;
    }

    public int getCommandIndex() {
        return commandIndex;
    }

    public boolean hasMoreCommands() {
        return commandIndex < commands.length();
    }

    public boolean isCollided() {
        return collided;
    }

    public void collide(String otherCarName) {
        collided = true;
        collidedWith = otherCarName;
    }

    public String getCollidedWith() {
        return collidedWith;
    }

    /**
     * Process the next command and move the car accordingly.
     * @param fieldWidth boundary of the field
     * @param fieldHeight boundary of the field
     */
    public void executeNextCommand(int fieldWidth, int fieldHeight) {
        if (hasMoreCommands() && !collided) {
            char command = commands.charAt(commandIndex);
            commandIndex++;
            switch (command) {
                case 'L':
                    direction = direction.turnLeft();
                    break;
                case 'R':
                    direction = direction.turnRight();
                    break;
                case 'F':
                    moveForward(fieldWidth, fieldHeight);
                    break;
            }
        }
    }

    /**
     * Move the car forward one grid point.
     * If car tries to move beyond the boundary, it will stay in its current position.
     */
    private void moveForward(int fieldWidth, int fieldHeight) {
        switch (direction) {
            case N:
                if (y + 1 < fieldHeight) y++;
                break;
            case E:
                if (x + 1 < fieldWidth) x++;
                break;
            case S:
                if (y - 1 >= 0) y--;
                break;
            case W:
                if (x - 1 >= 0) x--;
                break;
        }
    }
}
