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
    boolean guessed = false;
    int lowerLimit = 0;
    int upperLimit = 1000;
    int computerGuess = upperLimit / 2;

    // Game code
    void run() {
        // TODO: Implementation

        System.out.println("Think of a secret number not smaller than 0"
                        + " and not greater than 999. Type 'go' when you have one.");
        System.out.print(">");

        // User is ready to play
        if (sc.nextLine().equals("go")) {
            System.out.println(computerGuess);

            // Computer computes next guesses based on user input
            for (int i = 0; i < 10 && !guessed; i++) {
                System.out.print(">");
                String userInput = sc.nextLine();

                // Breaks the loop and ends the program
                if (userInput.equals("guessed")) {
                    guessed = true;
                
                // Computes next computer guess value if the user inputs "lower"
                } else if (userInput.equals("lower")) {
                    if (upperLimit > computerGuess) {
                        upperLimit = computerGuess;
                    }
                    computerGuess = (lowerLimit + upperLimit) / 2;
                    System.out.println(computerGuess);

                // Computes next computer guess value if the user inputs "higher"
                } else if (userInput.equals("higher")) {
                    if (lowerLimit < computerGuess) {
                        lowerLimit = computerGuess;
                    }
                    computerGuess = (lowerLimit + upperLimit) / 2;
                    System.out.println(computerGuess);
                }
            }
        }

        // If the user never inputs "guessed" the program gives up because the user is lying
        if (!guessed) {
            System.out.println("I give up");
        }
        // END TODO
    }

    // Runs the guessing game
    public static void main(String[] args) {
        new ComputerGame().run();
    }
}