# Auto Driving Car Simulation

## Project Structure
Here is the directory structure:
```css
autoDrivingCar/
├── build.gradle
├── settings.gradle
├── src/
│   ├── main/
│   │   └── java/
│   │       └── gic/
│   │           └── ryan/
│   │               ├── AutoDrivingCarApplication.java
│   │               ├── Car.java
│   │               ├── Field.java
│   │               ├── Direction.java
│   │               └── Command.java
│   └── test/
│       └── java/
│           └── gic/
│               └── ryan/
│                   ├── AutoDrivingCarApplicationTest.java
│                   ├── CarTest.java
│                   └── FieldTest.java
```

## Explanation and Assumptions

### Design Overview:
The project is designed to simulate a field with autonomous cars following specific commands. The main class `AutoDrivingCarApplication` serves as the entry point of the application.

### Assumptions:
- The field's bottom-left corner is at (0,0), and the top-right corner is at (width-1, height-1).
- The commands for each car are given as a string consisting of `L` (left), `R` (right), and `F` (forward).
- If a car attempts to move outside the field boundaries, the command is ignored, and the car stays in its current position.
- Cars are processed in steps, where at each step, only one command is processed for each car.
- In case of a collision, the cars involved in the collision stop moving.

## Instructions to Run the Application

### Environment Required
- JDK 17
- Gradle

### Environment Setup
1. **Ensure JDK 17 is installed** on your machine.
2. **Ensure Gradle is installed** on your machine.
3. **Set up your environment variables** to include the paths to JDK and Gradle.

### Running the Application
1. **Download the Source Code:**
   Download or copy the source code provided earlier into a directory on your computer.

2. **Navigate to the project directory:**
- Open a terminal (Linux/macOS) or command prompt (Windows).
- Use the cd command to navigate to the directory where you saved the source code. For example:
```sh
cd path-to-source-code/autoDrivingCar
```

3. **Build the project**:
```sh
gradle build
```

4. **Run the application**:
```sh
gradle run
```
or you can run:
```sh
java -jar build/libs/autoDrivingCar-1.0.jar
```

### Run Unit Tests
To run the unit tests, execute the following command in the terminal:
```sh
gradle test
```
This will compile the tests and run them, displaying the results in the terminal.

## Notes
- The provided commands assumes a Unix-like terminal environment. The commands and process may vary slightly based on your operating system.
- By following these instructions, you should be able to set up the environment, run the application, and execute the unit tests successfully.
- The project structure, explanations, and assumptions are provided to help understand the organization and functionality of the simulation.

## Additional Notes:
*Thank you for your time and consideration!*
*Please let me know if you have any further questions or encounter any issues.*

Copyright &copy; 2024, Ryan Le.