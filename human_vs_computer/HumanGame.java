import java.util.*;

/**
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 * @date 15-09-2022
 */

public class HumanGame {
    Scanner sc = new Scanner(System.in);
    Random randomGenerator;

    int numberOfGuesses = 0;

    void run() {
        // TODO: Implementation
        // generate random number based on a seed
        System.out.println("Type an arbitrary number");

        long seed = sc.nextLong();
        randomGenerator = new Random(seed);
        int n = randomGenerator.nextInt(100); // number the player has to guess
        int[] guesses = new int[7]; // guess history

        // game starts
        System.out.println("Start guessing!");
        for (int i = 0; i < 7; i++) {
            numberOfGuesses++;

            // store the guessed number into an array
            guesses[i] = sc.nextInt();

            // correct guess
            if (guesses[i] == n) {
                System.out.println("Good guess! You won.");
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

        System.out.println(numberOfGuesses + " guesses:");

        // array of dots for guess history
        Character[] dots = new Character[100];
        Arrays.fill(dots, '.');

        // guess history
        for (int i = 0; i < numberOfGuesses; i++) {
            // mark number to guess and the guessed number
            dots[n] = '|';
            dots[guesses[i]] = 'X';

            // print full array of a guess
            for (int j = 0; j < 100; j++) {
                System.out.print(dots[j]);
            }

            // clear "X" from array of dots
            dots[guesses[i]] = '.';
            System.out.println();
        }
        // END TODO
    }

    // Runs the guessing game
    public static void main(String[] args) {
        new HumanGame().run();
    }
}