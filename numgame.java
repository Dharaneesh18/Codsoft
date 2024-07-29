import java.util.Random;
import java.util.Scanner;

public class numgame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalScore = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int numberOfAttempts = 0;
            boolean guessedCorrectly = false;
            int maxAttempts = 10;

            System.out.println("I have generated a number between 1 and 100. Try to guess it!");

            while (numberOfAttempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                numberOfAttempts++;

                if (userGuess == numberToGuess) {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! You guessed the number in " + numberOfAttempts + " attempts.");
                    totalScore += (maxAttempts - numberOfAttempts + 1);
                    roundsWon++;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Your guess is too high.");
                } else {
                    System.out.println("Your guess is too low.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You didn't guess the number. The correct number was " + numberToGuess);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! You won " + roundsWon + " rounds with a total score of " + totalScore);
        scanner.close();
    }
}
