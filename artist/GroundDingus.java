import java.awt.Graphics;
import java.awt.Color;

/**
 * TreeDingus is an example of a slightly more advanced Dingus.
 * 
 * TreeDingus draws a "tree" using a rectangle as the trunk, and circle for a
 * crown.
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class GroundDingus extends Dingus {
    private int groundHeight;

    /**
     * Create and initialize a new TreeDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public GroundDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize PineDingus properties
        groundHeight = random.nextInt(maxY / 5) + maxY / 2;
    }

    @Override
    void draw(Graphics g) {
        // draw crown
        Color groundColor = new Color(random.nextInt(150) + 50, random.nextInt(100) + 155, random.nextInt(10) + 50, random.nextInt(50));
        g.setColor(groundColor);

        g.fillRect(0, groundHeight, maxX, maxY);

    }
}