import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test ABAutomaton.
 * 
 * TODO 3: FIll in your names and student IDs
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
public class ABAutomatonTest {
    ABAutomaton automaton = new ABAutomaton();

    @Test
    public void testGenToString() {
        // TODO 6: 
        // Add at least 5 test cases.
        // Motivate each test case with a line comment like this.

        // The original array has false values in the end to make computing the next gens easier.
        // These two false values are therefore not printed, 
        // which is accounted for in the expected value.

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
    public void testNextGenA() {
        // TODO 8: 
        // Add at least 8 test cases.
        // Motivate each test case with a line comment like this.
        
        // Tests if an empty cell stays false when neighbours are also false
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGenA(new boolean[]{false, false, false}));

        // Tests if an empty cell becomes true when left neighbour is true
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenA(new boolean[]{true, false, false}));
        
        // Tests if an empty cell becomes true when right neighbour is true
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenA(new boolean[]{false, false, true}));

        // Tests if an empty cell becomes true when both neighbours are true
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenA(new boolean[]{true, false, true}));

        // Tests if a true cell becomes false when both neighbours are false
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGenA(new boolean[]{false, true, false}));

        // Tests if a true cell stays true if the left neighbour is true
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenA(new boolean[]{true, true, false}));

        // Tests if a true cell stays true if the right neighbour is true
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenA(new boolean[]{false, true, true}));

        // Tests if a true cell becomes false if both neighbours are true
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGenA(new boolean[]{true, true, true}));
    }

    @Test
    public void testNextGenB() {
        // TODO 10: 
        // Add at least 8 test cases.
        // Motivate each test case with a line comment like this.

        // Tests if an empty cell stays empty if both neighbours are false
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGenB(new boolean[]{false, false, false}));

        // Tests if an empty cell becomes true if left neighbour is true
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenB(new boolean[]{true, false, false}));

        // Tests if an empty cell becomes true if right neighbour is true
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenB(new boolean[]{false, false, true}));

        // Tests if an empty cell stays empty if both neighbours are true
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGenB(new boolean[]{true, false, true}));

        // Tests if a true cell stays true if both neighbours are empty
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenB(new boolean[]{false, true, false}));

        // Tests if a true cell stays true if left neighbour is true
        assertArrayEquals(new boolean[]{false, true, false}, 
            automaton.nextGenB(new boolean[]{true, true, false}));

        // Tests if a true cell becomes false if right neighbour is true
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGenB(new boolean[]{false, true, true}));

        // Tests if a true cell becomes false if both neighbours are true
        assertArrayEquals(new boolean[]{false, false, false}, 
            automaton.nextGenB(new boolean[]{true, true, true}));
    }

}
