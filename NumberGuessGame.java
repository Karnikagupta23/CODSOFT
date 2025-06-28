import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MAX_ATTEMPTS = 7;
        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");

        while (playAgain) {
            int target = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n Round " + (roundsPlayed + 1) + " begins! You have " + MAX_ATTEMPTS + " attempts.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                
                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // skip invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < target) {
                    System.out.println(" Too low!");
                } else if (guess > target) {
                    System.out.println(" Too high!");
                } else {
                    System.out.println(" Correct! You guessed it in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You've used all attempts. The correct number was: " + target);
            }

            roundsPlayed++;

            System.out.print("Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n🏁 Game Over!");
        System.out.println("Total Rounds Played: " + roundsPlayed);
        System.out.println("Rounds Won: " + roundsWon);
        System.out.println("Thanks for playing! ");

        scanner.close();
    }
}




