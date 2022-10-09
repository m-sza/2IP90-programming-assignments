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
class SunDingus extends Dingus {
    private int sunSize;

    /**
     * Create and initialize a new TreeDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public SunDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize PineDingus properties
        sunSize = random.nextInt(100) + 50;
    }

    @Override
    void draw(Graphics g) {
        // draw crown
        Color sunColor = new Color(255, random.nextInt(50)+180, random.nextInt(10)+100);
        g.setColor(sunColor);

        g.fillOval(x, random.nextInt(maxY/3), sunSize, sunSize);

    }
}