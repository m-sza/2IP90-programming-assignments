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
class BirdDingus extends Dingus {
    private int birdSize;

    /**
     * Create and initialize a new TreeDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public BirdDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize PineDingus properties
        birdSize = random.nextInt(40) + 10;
    }

    @Override
    void draw(Graphics g) {
        // draw crown
        Color birdColor = new Color(random.nextInt(100), random.nextInt(100), random.nextInt(100));
        g.setColor(birdColor);

        int yy = random.nextInt(200);
        g.drawArc(x, yy, birdSize, birdSize / 2, 50, 130);
        g.drawArc(x+36*birdSize/50, yy, birdSize, birdSize / 2, 140, -130);

    }
}