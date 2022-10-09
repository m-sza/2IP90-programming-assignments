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
class CloudDingus extends Dingus {
    private int cloudHeight;
    private int cloudWidth;

    /**
     * Create and initialize a new TreeDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public CloudDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize PineDingus properties
        cloudHeight = random.nextInt(maxX / 8);
        cloudWidth = random.nextInt(maxX / 4);
    }

    @Override
    void draw(Graphics g) {
        // draw crown
        Color cloudColor = new Color(random.nextInt(10)+50, random.nextInt(25)+50, 255, random.nextInt(25));
        g.setColor(cloudColor);

        g.fillRect(x, random.nextInt(maxY/2), cloudWidth, cloudHeight);

    }
}