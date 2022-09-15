import java.util.*;

/**
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * @author Matyas Szabolcs
<<<<<<< HEAD
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 * @date 15-09-2022
=======
 * @id     1835521
 * @author Quinn Caris
 * @id     1779133
 * @date   15-09-2022
>>>>>>> 98f4201792df36bd5291d2ed7099ad9aa02a031a
 */

public class HumanGame {
    Scanner sc = new Scanner(System.in);
    Random randomGenerator;

<<<<<<< HEAD
    int numberOfGuesses = 0;

    void run() {
        // TODO: Implementation
        // generate random number based on a seed
        System.out.println("Type an arbitrary number");
        System.out.print(">");

        long seed = sc.nextLong();
        randomGenerator = new Random(seed);
        int n = randomGenerator.nextInt(100); // number the player has to guess
        int[] guesses = new int[7]; // guess history

        // game starts
        System.out.println("Start guessing!");
        for (int i = 0; i < 7; i++) {
            System.out.print(">");

            // store the guessed number into an array
            guesses[i] = sc.nextInt();

            // correct guess
            if (guesses[i] == n) {
                numberOfGuesses = i + 1;
                System.out.println("Good guess! You won.");
                System.out.println(numberOfGuesses + " guesses");
                break;
            // guess too low
            } else if (guesses[i] < n) {
                System.out.println("higher");
            // guess too high
            } else if (guesses[i] > n) {
                System.out.println("lower");
            }
            // out of guesses
            if (i == 6) {
                System.out.println("No more guesses, you lost.");
            }
        }

        // array of dots for guess history
        Character[] dots = new Character[100];
        Arrays.fill(dots, '.');


        // guess history
        for (int i = 0; i < numberOfGuesses; i++) {
            // mark number to guess and the guessed number
            dots[n - 1] = '|';
            dots[guesses[i] - 1] = 'X';

            // print full array of a guess
            for (int j = 0; j < 100; j++) {
                System.out.print(dots[j]);
            }

            // clear "X" from array of dots
            dots[guesses[i] - 1] = '.';
=======
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
>>>>>>> 98f4201792df36bd5291d2ed7099ad9aa02a031a
            System.out.println();
        }
        // END TODO
    }

    // Runs the guessing game
    public static void main(String[] args) {
        new HumanGame().run();
    }
}