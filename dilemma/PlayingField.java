import java.util.Random;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


/**
 * Playingfield.
 * 
 * INCOMPLETE
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part PlayingField
 * 
 * assignment copyright Kees Huizing
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class PlayingField extends JPanel /* possible implements ... */ {

    public Patch[][] grid = new Patch[50][50];

    double alpha; // defection award factor

    private Timer timer;

    private int counter;


    PrisonersDilemma prisonersDilemma = new PrisonersDilemma();

    // random number generator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random RANDOM = new Random(SEED);


    /**
     * Initializes a grid of random patch strategies.
     */
    public void setInitialGrid() {
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 50; x++) {
                grid[y][x] = new Patch();
            }
        }
        for (int y = 0; y < 50; y++) {
            for (int x = 0; x < 50; x++) {
                grid[y][x].randomizePatch();
            }
        }
    }


    /**
     * Calculate and execute one step in the simulation.
     */
    public void step() {
        for (int y = 0; y < grid.length - 1; y++) {
            for (int x = 0; x < grid[0].length - 1; x++) {
                if (changeStrategy(x, y)) {
                    grid[y][x].toggleStrategy();
                }
            }
        }
    }


    /**
     * Determines the coordinates of the neighbours of the given patch.
     * 
     * @param x coordinate
     * @param y coordinate
     * @return neighbour coordinates
     */
    public int[] neighbour(int x, int y) {
        int[] neighbour = new int[2];
        if (counter == 8) {
            counter = 0;
        }
        if (counter == 0) {
            //top
            if (y == 0) {
                neighbour[0] = x;
                neighbour[1] = grid.length - 1;
            } else {
                neighbour[0] = x;
                neighbour[1] = y - 1;
            }
        } else if (counter == 1) {
            //top-right
            if (x == grid[0].length - 1 && y == 0) {
                neighbour[0] = 0;
                neighbour[1] = grid.length - 1;
            } else if (y == 0) {
                neighbour[0] = x + 1;
                neighbour[1] = grid.length - 1;
            } else if (x == grid[0].length - 1) {
                neighbour[0] = 0;
                neighbour[1] = y - 1;
            } else {
                neighbour[0] = x + 1;
                neighbour[1] = y - 1;
            }
        } else if (counter == 2) {
            //right
            if (x == grid[0].length - 1) {
                neighbour[0] = 0;
                neighbour[1] = y;
            } else {
                neighbour[0] = x + 1;
                neighbour[1] = y;
            }
        } else if (counter == 3) {
            //bottom-right
            if (x == grid[0].length - 1 && y == grid.length - 1) {
                neighbour[0] = 0;
                neighbour[1] = 0;
            } else if (x == grid[0].length - 1) {
                neighbour[0] = 0;
                neighbour[1] = y + 1;
            } else if (y == grid.length - 1) {
                neighbour[0] = x + 1;
                neighbour[1] = 0;
            } else {
                neighbour[0] = x + 1;
                neighbour[1] = y + 1;
            }
        } else if (counter == 4) {
            //bottom
            if (y == grid.length - 1) {
                neighbour[0] = x;
                neighbour[1] = 0;
            } else {
                neighbour[0] = x;
                neighbour[1] = y + 1;
            }
        } else if (counter == 5) {
            //bottom-left
            if (x == 0 && y == grid.length - 1) {
                neighbour[0] = grid[0].length - 1;
                neighbour[1] = 0;
            } else if (x == 0) {
                neighbour[0] = grid[0].length - 1;
                neighbour[1] = y + 1;
            } else if (y == grid.length - 1) {
                neighbour[0] = x - 1;
                neighbour[1] = 0;
            } else {
                neighbour[0] = x - 1;
                neighbour[1] = y + 1;
            }
        } else if (counter == 6) {
            //left
            if (x == 0) {
                neighbour[0] = grid[0].length - 1;
                neighbour[1] = y;
            } else {
                neighbour[0] = x - 1;
                neighbour[1] = y;
            }
        } else if (counter == 7) {
            //top-left
            if (x == 0 && y == 0) {
                neighbour[0] = grid[0].length - 1;
                neighbour[1] = grid.length - 1;
            } else if (x == 0) {
                neighbour[0] = grid[0].length - 1;
                neighbour[1] = y - 1;
            } else if (y == 0) {
                neighbour[0] = x - 1;
                neighbour[1] = grid.length - 1;
            } else {
                neighbour[0] = x - 1;
                neighbour[1] = y - 1;
            }
        }
        counter++;
        return neighbour;
    }

    /**
     * Calculates the score of a Patch.
     * @param x coordinate
     * @param y coordinate
     * @return score
     */
    public double scoreCalc(int x, int y, double alpha) {
        double score = 0.0;
        for (int n = 0; n < 8; n++) {
            int[] neighbour = neighbour(x, y);
            if (grid[neighbour[1]][neighbour[0]].isCooperating() 
                && grid[y][x].isCooperating()) {
                score++;
            } else if (grid[neighbour[1]][neighbour[0]].isCooperating() 
                && !grid[y][x].isCooperating()) {
                score = score + alpha;
            }
        }
        return score;
    }

    /**
     * Calculates the score of the entire grid.
     * @return a 2D array of all the scores throughout the entire grid
     */
    public double[][] scoreGrid() {
        double[][] scoreGrid = new double[grid.length][grid[0].length];
        for (int y = 0; y < grid.length - 1; y++) {
            for (int x = 0; x < grid[0].length - 1; x++) {
                scoreGrid[y][x] = scoreCalc(x, y, alpha);
            }
        }
        return scoreGrid;
    }

    /**
     * Determines whether the given Patch should change their strategy or not.
     * @param x coordinate
     * @param y coordinate
     * @param score of the patch
     * @return true if it should change, false if not
     */
    public boolean changeStrategy(int x, int y) {
        double[][] scoreGrid = scoreGrid();
        double highestScore = 0.0;
        int[] highestNeighbour = new int[2];
        int[] neighbour = new int[2];
        for (int n = 0; n < 8; n++) {
            neighbour = neighbour(x, y);
            if (scoreGrid[neighbour[1]][neighbour[0]] > highestScore) {
                highestScore = scoreGrid[neighbour[1]][neighbour[0]];
                highestNeighbour = neighbour;
            }
        }
        if (highestScore > scoreGrid[y][x]) {
            if (grid[y][x].isCooperating() 
                != grid[highestNeighbour[1]][highestNeighbour[0]].isCooperating()) {
                return true;
            }
        }
        return false;
    }

    public void setAlpha() {
        alpha = getAlpha();
    }

    /**
     * Alpha of this playing field.
     * 
     * @return alpha value for this field.
     */
    public double getAlpha() {
        return prisonersDilemma.getAlphaFromDilemma();
    }

    /**
     * Grid as 2D boolean array.
     * 
     * Precondition: Grid is rectangular, has a non-zero size, and all elements are non-null.
     * 
     * @return 2D boolean array, with true for cooperators and false for defectors
     */
    public boolean[][] getGrid() {
        boolean[][] resultGrid = new boolean[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                resultGrid[x][y] = grid[x][y].isCooperating();
            }
        }
        return resultGrid;
    }

    /**
     * Set this fields grid.
     * 
     * All patches in the grid become cooperating if the corresponding item in inGrid is true.
     * 
     * @param inGrid 2D array, with true for cooperators and false for defectors.
     */
    public void setGrid(boolean[][] inGrid) {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (inGrid[x][y] && !grid[x][y].isCooperating()) {
                    grid[x][y].toggleStrategy();
                } else if (!inGrid[x][y] && grid[x][y].isCooperating()) {
                    grid[x][y].toggleStrategy();
                }
            }
        }
    }
    
    
}