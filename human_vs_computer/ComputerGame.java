import java.util.Scanner;

/**
 * Simple number guessing game for computers.
 * 
 * Think of a number and type "go". Your computer starts guessing
 * your number. Reply "lower" when the guess is too high, "higher"
 * when it is too low, and "guessed" when the computer guessed
 * your number correctly.
 *
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 * @date 15-09-2022
 */

public class ComputerGame {
    Scanner sc = new Scanner(System.in);

    // Declaring variables used in the code
    int lowerLimit = 0;
    int upperLimit = 1000;
    int guess = upperLimit / 2;

    // Game code
    void run() {
        // TODO: Implementation

        System.out.println(
                "Think of a secret number not smaller than 0 and not greater than 999. Type 'go' when you have one.");

        // User is ready to play
        if (sc.nextLine().equals("go")) {
            System.out.println(guess);
        }

        // Computer computes next guesses based on user input
        for (int i = 0; i < 10; i++) {
            String userInput = sc.nextLine();

            // Give up when user is lying
            if (i == 9) {
                System.out.println("I give up");
                break;
            }
            // Break when guess is correct
            if (userInput.equals("guessed")) {
                break;
                
            // Compute next guess if user inputs "lower"
            } else if (userInput.equals("lower")) {
                if (upperLimit > guess) {
                    upperLimit = guess;
                }
                guess = (lowerLimit + upperLimit) / 2;
                System.out.println(guess);

            // Compute next guess if user inputs "higher"
            } else if (userInput.equals("higher")) {
                if (lowerLimit < guess) {
                    lowerLimit = guess;
                }
                guess = (lowerLimit + upperLimit) / 2;
                System.out.println(guess);
            }
        }

        // END TODO
    }

    // Runs the guessing game
    public static void main(String[] args) {
        new ComputerGame().run();
    }
}