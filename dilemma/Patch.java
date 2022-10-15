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

    PlayingField playingField = new PlayingField();

    /**
     * Determine if this patch is cooperating.
     * 
     * @return true if and only if the patch is cooperating.
     */
    boolean isCooperating() {
        //should be implemented somewhere in the future, but I don't know how
        return false;
    }
    
    /**
     * Set strategy to cooperate (C) when isC is true, D otherwise.
     * 
     * @param isC use cooperation strategy.
     */
    void setCooperating(boolean isC) {
        //not necessary (yet)
    }
    
    /**
     * Toggle strategy between C and D.
     */
    void toggleStrategy() {
        //should be implemented as well for the other code to work,
        //but I've got no clue how to do that
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
}