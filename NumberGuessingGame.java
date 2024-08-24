import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 7;
        int totalScore = 0;
        
        System.out.println("Welcome to the Number Guessing Game!\n");
        boolean continuePlaying = true;
        
        while (continuePlaying) {
            int targetNumber = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            System.out.printf("New Round - Guess a number between %d and %d\n", MIN_RANGE, MAX_RANGE);
            System.out.println("You have " + MAX_ATTEMPTS + " chances to guess the number.\n");
            
            int attemptCount = 0;
            boolean isGuessedCorrectly = false;
            
            while (attemptCount < MAX_ATTEMPTS) {
                System.out.print("Please enter your guess: ");
                int userGuess = scanner.nextInt();
                
                attemptCount++;
                
                if (userGuess == targetNumber) {
                    System.out.printf("Congratulations! You found the number in %d attempts.\n", attemptCount);
                    totalScore += attemptCount;
                    isGuessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Your guess is too low. Try again.\n");
                } else {
                    System.out.println("Your guess is too high. Try again.\n");
                }
            }
            
            if (!isGuessedCorrectly) {
                System.out.println("Out of attempts! The number was " + targetNumber);
            }
            
            System.out.println("Your score so far: " + totalScore + "\n");
            
            System.out.print("Would you like to play another round? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes")) {
                continuePlaying = false;
            }
        }
        
        System.out.println("Thanks for playing the Number Guessing Game! Your final score is: " + totalScore);
        
        scanner.close();
    }
}
