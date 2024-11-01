import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10; // Maximum attempts per round
        int roundsPlayed = 0;
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Game!");
        
        boolean playAgain;
        
        do {
            roundsPlayed++;
            int targetNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("\nRound " + roundsPlayed + ": Guess a number between " + lowerBound + " and " + upperBound + ".");
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                
                if (guess == targetNumber) {
                    System.out.println("Congratulations! You've guessed the correct number.");
                    guessedCorrectly = true;
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }
                
                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }
            
            System.out.print("Would you like to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
            
        } while (playAgain);
        
        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + roundsPlayed);
        System.out.println("Your total score: " + totalScore);
        
        scanner.close();
    }
}
