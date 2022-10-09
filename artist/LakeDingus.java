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
class LakeDingus extends Dingus {
    private int lakeWidth;
    private int lakeHeight;

    /**
     * Create and initialize a new TreeDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public LakeDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize PineDingus properties
        lakeWidth = random.nextInt(150)+150;
        lakeHeight = random.nextInt(50)+50;
    }

    @Override
    void draw(Graphics g) {
        // draw crown
        Color lakeColor = new Color(random.nextInt(50), random.nextInt(50)+100, random.nextInt(50)+200, random.nextInt(200)+55);
        g.setColor(lakeColor);

        g.fillOval(x, random.nextInt(maxY/3)+(2*maxY/3), lakeWidth, lakeHeight);

    }
}