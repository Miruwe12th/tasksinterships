import java.util.Random;
import java.util.Scanner;

public class NumGuessGame {
    public static void main(String[] args) {
        Scanner sbc = new Scanner(System.in);
        Random rand = new Random();
        String playAgain = " ";
        int totalScore = 0;
        do {
            int attempts = 0;
            int guessNum = rand.nextInt(100) + 1;
            int guess = 0;
            while (guess != guessNum && attempts < 10) {
                System.out.print("Enter your guess (between 1 and 100): ");
                guess = sbc.nextInt();
                attempts++;
                if (guess > guessNum) {
                    System.out.println("Too high!");
                } else if (guess < guessNum) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("CORRECT! You've GUESSED the number in " + attempts + " attempts.");
                    totalScore += (10- attempts + 1); 
                }
            }
            if (guess != guessNum) {
                System.out.println("SORRY, THE NUMBER WASN'T GUESSED WITHIN 10 ATTEMPTS.BETTER LUCK NEXT             TIME. The number was: " + guessNum);
            }
            System.out.println("Your total score is: " + totalScore);
            System.out.println("Would you like to play again? (yes/no)");
            playAgain = sbc.next();
        } while (playAgain.equalsIgnoreCase("yes"));
            sbc.close();
    }
}
