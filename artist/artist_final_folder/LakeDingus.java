import java.awt.Color;
import java.awt.Graphics;


/**
 * LakeDingus draws the lake in the grassfield.
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
     * Create and initialize a new LakeDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public LakeDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize LakeDingus properties
        lakeWidth = random.nextInt(150) + 150;
        lakeHeight = random.nextInt(50) + 50;
    }

    @Override
    void draw(Graphics g) {
        Color lakeColor = new Color(random.nextInt(50), random.nextInt(50) + 100, 
            random.nextInt(50) + 200, random.nextInt(200) + 55);
        g.setColor(lakeColor);

        g.fillOval(x, random.nextInt(maxY / 3) + (2 * maxY / 3), lakeWidth, lakeHeight);

    }
}