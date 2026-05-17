import java.util.Scanner;
import java.util.Random;

public class GameEngine {
    private Scanner scanner;
    private InputValidator validator;
    private int secretNumber;
    private int attempts;
    private final int MAX_ATTEMPTS = 5; // 🛑 Limit set to exactly 5 attempts

    public GameEngine() {
        this.scanner = new Scanner(System.in);
        this.validator = new InputValidator();
    }

    public void start() {
        Random random = new Random();
        this.secretNumber = random.nextInt(100) + 1;
        this.attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("=========================================");
        System.out.println("🎯 WELCOME TO THE SMART GUESSING GAME 🎯");
        System.out.println("=========================================");
        System.out.println("I have chosen a number between 1 and 100.");
        System.out.println("Can you beat the system in " + MAX_ATTEMPTS + " attempts?");

        // Loop cuts off if they guess correctly OR reach 5 attempts
        while (!hasGuessedCorrectly && this.attempts < MAX_ATTEMPTS) {
            System.out.print("\nEnter your guess (Attempt " + (this.attempts + 1) + "/" + MAX_ATTEMPTS + "): ");

            // 1.Is it an integer?
            if (!this.validator.isAnInteger(this.scanner)) {
                continue;
            }

            // 2.Extract the number EXACTLY ONCE here
            int userGuess = this.scanner.nextInt();

            // 3.Is it between 1 and 100?
            if (!this.validator.isInBounds(userGuess)) {
                continue;
            }

            this.attempts++;

            // 4.Proximity & Direction Logic
            int distance = Math.abs(userGuess - this.secretNumber);

            if (userGuess == this.secretNumber) {
                System.out.println("\n🎉 CONGRATULATIONS! You got it!");
                System.out.println("🏅 It took you exactly " + this.attempts + " attempts.");
                hasGuessedCorrectly = true;
            } else {
                // Proximity Hint
                if (distance <= 10) {
                    System.out.print("🔥 You're super warm! ");
                } else {
                    System.out.print("❄️ You're freezing cold! ");
                }

                // Direction Hint
                if (userGuess < this.secretNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }
            }
        }

        // 5.Show the right answer if they ran out of attempts
        if (!hasGuessedCorrectly) {
            System.out.println("\n💀 GAME OVER! You ran out of attempts.");
            System.out.println("The correct secret number was: " + this.secretNumber);
        }

        this.scanner.close();
    }
}