import java.util.Scanner;

public class InputValidator {

    // Checks if the user typed text instead of a number without extracting it
    public boolean isAnInteger(Scanner scanner) {
        if (!scanner.hasNextInt()) {
            System.out.println("❌ Hey, that is not a valid number! Please type a whole number.");
            scanner.next(); // Clear out the bad text input
            return false;
        }
        return true;
    }

    // Handles the range checking on a number that was already extracted
    public boolean isInBounds(int number) {
        if (number >= 1 && number <= 100) {
            return true;
        } else {
            System.out.println("⚠️ Please keep your guess between 1 and 100!");
            return false;
        }
    }
}