import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * TODO 3: Fill in your names and student IDs:
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class ABAutomaton {
    Scanner scanner = new Scanner(System.in);

    /**
     * Converts a generation array to a string that can be printed.
     */
    String genToString(boolean[] gen) {
        // TODO 5
        String currentGen = "";
        for (int i = 1; i < (gen.length - 1); i++) {
            // If the cell is true, it prints a * and otherwise a regular space
            if (gen[i]) {
                currentGen = currentGen + "*";
            } else {
                currentGen = currentGen + " ";
            }
        }
        return currentGen;
    }

    /**
     * Calculates the next gen based on the ruleset of automaton A.
     */
    boolean[] nextGenA(boolean[] gen) {
        // TODO 7
        boolean[] nextGenA = new boolean[gen.length];
        for (int i = 1; i < (gen.length - 1); i++) {
            // If a cell is true, checks whether its neighbours are both true or both false
            if (gen[i]) {
                if ((gen[i - 1] && gen[i + 1]) || (!gen[i - 1] && !gen[i + 1])) {
                    nextGenA[i] = false;
                } else {
                    nextGenA[i] = true;
                }
            // If a cell is false, checks whether both neighbours are empty
            } else {
                if (!gen[i - 1] && !gen[i + 1]) {
                    nextGenA[i] = false;
                } else {
                    nextGenA[i] = true;
                }
            }
        }
        return nextGenA;
    }

    /**
     * Calculates the next gen based on the ruleset of automaton B.
     */
    boolean[] nextGenB(boolean[] gen) {
        // TODO 9
        boolean[] nextGenB = new boolean[gen.length];
        for (int i = 1; i < (gen.length - 1); i++) {
            // If a cell is true, checks whether the right neighbour is false
            if (gen[i]) {
                if (!gen[i + 1]) {
                    nextGenB[i] = true;
                } else {
                    nextGenB[i] = false;
                }
            // If a cell is false, checks whether both neighbors are true or both are false
            } else {
                if ((gen[i - 1] && gen[i + 1]) || (!gen[i - 1] && !gen[i + 1])) {
                    nextGenB[i] = false;
                } else {
                    nextGenB[i] = true;
                }
            }
        }
        return nextGenB;
    }

    /**
     * Reads the input the user gives the program for the first gen.
     */
    boolean[] readInitalGeneration(int length) {
        // TODO 11

        // Declaring variables to be used in the method
        boolean[] firstgen = new boolean[length + 2];
        String scannedItem = "";
        int locationOfCell = 0;

        // Starts the scanning process for declaring the first gen by the user
        if (scanner.next().equals("init_start")) {
            scannedItem = scanner.next();
            // As long as the user doesn't stop the defining of the cells, this loops
            while (!scannedItem.equals("init_end")) {
                locationOfCell = Integer.parseInt(scannedItem);
                // Checks whether the given integer is within the length of the 
                // generation and ignores it otherwise
                if (locationOfCell <= length) {
                    firstgen[locationOfCell] = true;
                }
                scannedItem = scanner.next();
            }
        }
        return firstgen;
    }

    void run() {
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numOfGens; i++) {
            // Display the current generation
            System.out.println(genToString(gen));

            // And determine the next generation
            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}
