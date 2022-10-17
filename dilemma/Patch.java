/**
 * Patch.
 * 
 * INCOMPLETE 
 * Assignment 6 -- Prisoner's Dilemma -- 2ip90
 * part Patch
 * assignment copyright Kees Huizing
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class Patch {

    boolean strategy = false; //true if cooperating, false if defect

    /**
     * Determine if this patch is cooperating.
     * 
     * @return true if and only if the patch is cooperating.
     */
    boolean isCooperating() {
        return this.strategy;
    }
    
    /**
     * Set strategy to cooperate (C) when isC is true, D otherwise.
     * 
     * @param isC use cooperation strategy.
     */
    void setCooperating(boolean isC) {
        //not necessary (yet)
        if (isC) {
            this.strategy = true;
        } else {
            this.strategy = false;
        }
    }
    
    /**
     * Toggle strategy between C and D.
     */
    void toggleStrategy() {
        this.strategy = !strategy;
    }
    
    /**
     * Score of this patch in the current round.
     * 
     * @return the score
     */
    double getScore() {
        //this function is no longer needed since it has been done in PlayingField.java
        return 0.0; 
    }

    /**
     * Randomizes one patch for the initialization of the grid.
     */
    void randomizePatch() {
        int randomInt = PlayingField.RANDOM.nextInt(100);
        boolean randombool = false;
        if (randomInt < 50) {
            randombool = true;
        }
        this.strategy = randombool;
    }
}