import java.awt.Color;
import java.awt.Graphics;


/**
 * CloudDingus draws the clouds in the sky with a random transparency level.
 * 
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
     * Initializing CloudDingus properties.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public CloudDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize CloudDingus properties
        cloudHeight = random.nextInt(maxX / 8);
        cloudWidth = random.nextInt(maxX / 4);
    }

    @Override
    void draw(Graphics g) {
        // draw crown
        Color cloudColor = new Color(0, random.nextInt(25) + 50, 255, random.nextInt(10));
        g.setColor(cloudColor);

        g.fillRect(x, random.nextInt(maxY / 3), cloudWidth, cloudHeight);

    }
}