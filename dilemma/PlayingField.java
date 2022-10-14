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

    private Patch[][] grid;

    private double alpha; // defection award factor

    private Timer timer;

    private int counter;


    PrisonersDilemma prisonersDilemma = new PrisonersDilemma();

    // random number generator
    private static final long SEED = 37L; // seed for random number generator; any number goes
    public static final Random RANDOM = new Random(SEED);

    // ...

    /**
     * Calculate and execute one step in the simulation.
     */
    public void step() {
        boolean[][] prisonGrid = getGrid();
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
        //ignore this haha
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

    public void setAlpha(double alpha) {
        alpha = getAlpha();
    }

    /**
     * Alpha of this playing field..
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