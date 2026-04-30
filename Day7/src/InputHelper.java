import java.util.InputMismatchException;
import java.util.Scanner;

class InputHelper{
    int checkInteger(Scanner scanner){
        while(true){
            try{
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }
            catch(InputMismatchException exception){
                System.out.println("Something went wrong. Try again.");
                scanner.nextLine();
            }
        }
    }

    double checkDouble(Scanner scanner){
        while (true){
            try{
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            }
            catch (InputMismatchException exception){
                System.out.println("Something went wrong. Try again.");
                scanner.nextLine();
            }
        }
    }

    boolean confirmAction(Scanner scanner){
        System.out.println("Are you sure?\nYes - 1\nNo - 2");
        while(true) {
            int confirmChoice = checkInteger(scanner);
            if (confirmChoice == 1) {
                return true;
            } else if (confirmChoice == 2) {
                return false;
            } else {
                System.out.println("Invalid choice. Enter 1 or 2.");
            }
        }
    }

    boolean continueAction(Scanner scanner){
        System.out.println("----------------------------------\n" +
                "Do you want to continue?\nYes - 1\nBack to menu - 2" +
                "\n----------------------------------");
        while(true) {
            int continueChoice = checkInteger(scanner);
            if (continueChoice == 1) {
                return true;
            } else if (continueChoice == 2) {
                return false;
            } else {
                System.out.println("Invalid choice. Enter 1 or 2.");
            }
        }
    }

    String checkString(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Try again.");
        }
    }

}
