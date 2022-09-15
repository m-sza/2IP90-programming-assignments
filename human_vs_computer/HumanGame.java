import java.util.*; // For Scanner, Random, etc.

/** 
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * @author Matyas Szabolcs
 * @id     1835521
 * @author Quinn Caris
 * @id     1779133
 * @date   15-09-2022
 */
public class HumanGame {
    Scanner sc = new Scanner(System.in);
    Random randomGenerator;

    boolean guessed = false;
    int guessedNumber = 0;
    int numberOfGuesses = 0;

    // The code for the guessing game
    void run() {
        // TODO: Implementation
        // Generates a random number based on the arbitrary number the user inputs
        System.out.println("Type an arbitrary number");
        System.out.print(">");
        long seed = sc.nextLong();
        randomGenerator = new Random(seed);
        int code = randomGenerator.nextInt(100);

        // Declares arrays for the guess history part at the end of the guessing game
        int[] guessHistory;
        guessHistory = new int[7];
        String[] dots;
        dots = new String[100];

        System.out.println("Start guessing!");

        // The loop that runs during the actual guessing game
        for (int i = 0; i <= 6 && !guessed; i++) {
            numberOfGuesses++;
            System.out.print(">");
            guessedNumber = sc.nextInt();

            // Stores the guessed number into an array to use during the guess history section
            guessHistory[i] = guessedNumber;
            if (guessedNumber == code) {
                guessed = true;
                System.out.println("Good guess! You won.");
            } else if (guessedNumber < code) {
                System.out.println("higher");
            } else if (guessedNumber > code) {
                System.out.println("lower");
            }
        }
        if (!guessed) {
            System.out.println("No more guesses, you lost.");
        }

        // Creates an array full of dots to show during the guess history section
        for (int i = 0; i < 100; i++) {
            dots[i] = ".";
        }

        // Guess history section
        System.out.println(numberOfGuesses + " guesses");
        for (int i = 0; i < numberOfGuesses; i++) {
            // Marks the spots of the code and the guessed number
            dots[guessHistory[i] - 1] = "X";
            dots[code - 1] = "|";

            // Checks if a correct guess was made and replaces the "|" by a "X" if that's the case
            if (code == guessHistory[i]) {
                dots[code - 1] = "X";
            }

            // Prints the full array of one guess
            for (int a = 0; a < 100; a++) {
                System.out.print(dots[a]);
            }
            
            // Replaces the "X" of the previous guess with a dot so the previous guesses 
            // don't carry over to the next ones
            dots[guessHistory[i] - 1] = ".";
            System.out.println();
        }
        // END TODO
    }

    // Runs the guessing game
    public static void main(String[] args) {
        new HumanGame().run();
    }
}