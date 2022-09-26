import java.util.Scanner;

/**
 * Universal Automaton.
 * 
 * TODO 3: Fill in your names and student IDs
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class UniversalAutomaton {
    Scanner scanner = new Scanner(System.in);

    /**
     * Converts a generation array to a string that can be printed.
     */
    String genToString(boolean[] gen) {
        // TODO 13: Copy from ABAutomaton.java
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
     * Calculates the next gen based on the ruleset the user inputs.
     */
    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        // TODO 14

        // Checking for every available combination if the ruleset index for that combination 
        // is true and if it is true it changes the subsequent value of the nextGen to true as well.
        boolean[] nextGenU = new boolean[gen.length];
        for (int i = 1; i < (gen.length - 1); i++) {
            if (!gen[i] && !gen[i - 1] && !gen[i + 1] && ruleSequence[0]) {
                nextGenU[i] = true;
            } else if (!gen[i] && !gen[i - 1] && gen[i + 1] && ruleSequence[1]) {
                nextGenU[i] = true;
            } else if (!gen[i] && gen[i - 1] && !gen[i + 1] && ruleSequence[4]) {
                nextGenU[i] = true;
            } else if (!gen[i] && gen[i - 1] & gen[i + 1] && ruleSequence[5]) {
                nextGenU[i] = true;
            } else if (gen[i] && !gen[i - 1] && !gen[i + 1] && ruleSequence[2]) {
                nextGenU[i] = true;
            } else if (gen[i] && !gen[i - 1] && gen[i + 1] && ruleSequence[3]) {
                nextGenU[i] = true;
            } else if (gen[i] && gen[i - 1] && !gen[i + 1] && ruleSequence[6]) {
                nextGenU[i] = true;
            } else if (gen[i] && gen[i - 1] && gen[i + 1] && ruleSequence[7]) {
                nextGenU[i] = true;
            }
        }
        return nextGenU;
    }

    /**
     * Reads the input the user gives the program for the first gen.
     */
    boolean[] readInitalGeneration(int length) {
        // TODO 16: Copyt from ABAutomaton.java

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

    /**
     * Reads the rule sequence the user inputs.
     */
    boolean[] readRuleSequence() {
        // TODO 17
        int scannedItem = 0;
        boolean[] ruleSequence = new boolean[8];

        // A simple loop to store the values of the ones and zeroes inputted by the user 
        // to a boolean array used in the nextGen method.
        for (int i = 0; i < 8; i++) {
            scannedItem = scanner.nextInt();
            if (scannedItem == 1) {
                ruleSequence[i] = true;
            } else {
                ruleSequence[i] = false;
            }
        }
        return ruleSequence;
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(generationLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}