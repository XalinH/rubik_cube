import java.util.Scanner;

public class Main {

    public static void clearTerminal() {
        System.out.println("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public static void getUserResponse(Scanner scanner, Cube currentCube) {
        while(true) {
            System.out.print("What move would you like to do?: ");
            String response = scanner.nextLine();
            switch(response.toUpperCase()) {
                case "U":
                    currentCube.moveU();
                    return;
                case "U'":
                    currentCube.moveUPrime();
                    return;
                case "L":
                    currentCube.moveL();
                    return;
                case "L'":
                    currentCube.moveLPrime();
                    return;
                case "F":
                    currentCube.moveF();
                    return;
                case "F'":
                    currentCube.moveFPrime();
                    return;
                case "R":
                    currentCube.moveR();
                    return;
                case "R'":
                    currentCube.moveRPrime();
                    return;
                case "B":
                    currentCube.moveB();
                    return;
                case "B'":
                    currentCube.moveBPrime();
                    return;
                case "D":
                    currentCube.moveD();
                    return;
                case "D'":
                    currentCube.moveDPrime();
                    return;
                default:
                    continue;
            }
        }
    }

    public static void mainLoop(Scanner scanner, Cube currentCube) {
        while(true) {
            System.out.println(currentCube);
            getUserResponse(scanner, currentCube);
            clearTerminal();
        }
    }


    public static void main(String[] args) {
        clearTerminal();
        Scanner scanner = new Scanner(System.in);
        Cube newCube = new Cube();
        newCube.scramble();
        mainLoop(scanner, newCube);
        scanner.close();
    }
}