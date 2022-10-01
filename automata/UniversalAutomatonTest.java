import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test UniversalAutomaton.
 * 
 * TODO 3: Fill in your names and student IDs
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
public class UniversalAutomatonTest {
    UniversalAutomaton automaton = new UniversalAutomaton();

    @Test
    public void testGenToString() {
        // TODO 13:
        // Copy your test cases from ABAutomatonTest.java
        // Motivate each test case with a line comment like this.

        // Testing an empty array
        assertEquals("", automaton.genToString(new boolean[]{}));

        // Testing a fully true gen
        assertEquals("************", automaton.genToString(
            new boolean[]{false, true, true, true, true, true, true, true,
                true, true, true, true, true, false}));
        
        // Testing for if the not-shown cells are true (which they shouldn't be allowed to be)
        assertEquals(" * ", automaton.genToString(new boolean[]{true, false, true, false, true}));

        // Testing for an empty gen
        assertEquals("", automaton.genToString(new boolean[]{false, false}));

        // Testing an array with too few elements
        assertEquals("", automaton.genToString(new boolean[]{false}));
    }

    @Test
    public void testNextGen() {
        // TODO 15:
        // Motivate each test case with a line comment like this.

        // Using two ruleSequences with alternating values of true and false ensures 
        // we check if the program works for both for every particular rule.
        boolean[] ruleSequenceA = new boolean[]{true, false, true, false, true, false, true, false};
        boolean[] ruleSequenceB = new boolean[]{false, true, false, true, false, true, false, true};

        // Tests if an empty cell has no neighbours
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGen(ruleSequenceA, new boolean[]{false, false, false}));
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGen(ruleSequenceB, new boolean[]{false, false, false}));

        // Tests if an empty cell has a left neighbour
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGen(ruleSequenceA, new boolean[]{true, false, false}));
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGen(ruleSequenceB, new boolean[]{true, false, false}));

        // Tests if an empty cell has a right neighbour
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGen(ruleSequenceA, new boolean[]{false, false, true}));
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGen(ruleSequenceB, new boolean[]{false, false, true}));

        // Tests if an empty cell has two neighbours
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGen(ruleSequenceA, new boolean[]{true, false, true}));
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGen(ruleSequenceB, new boolean[]{true, false, true}));

        // Tests if a true cell has no neighbours
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGen(ruleSequenceA, new boolean[]{false, true, false}));
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGen(ruleSequenceB, new boolean[]{false, true, false}));

        // Tests if a true cell has a left neighbour
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGen(ruleSequenceA, new boolean[]{true, true, false}));
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGen(ruleSequenceB, new boolean[]{true, true, false}));

        // Tests if a true cell has a right neighbour
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGen(ruleSequenceA, new boolean[]{false, true, true}));
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGen(ruleSequenceB, new boolean[]{false, true, true}));

        // Tests if a true cell has two neighbours
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGen(ruleSequenceA, new boolean[]{true, true, true}));
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGen(ruleSequenceB, new boolean[]{true, true, true}));
    }

}