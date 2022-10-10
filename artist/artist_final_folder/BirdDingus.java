import java.awt.Color;
import java.awt.Graphics;

/**
 * BirdDingus uses two arcs to draw a bird in the sky.
 * 
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class BirdDingus extends Dingus {
    private int birdSize;

    /**
     * Create and initialize a new BirdDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public BirdDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize BirdDingus properties
        birdSize = random.nextInt(40) + 10;
    }

    @Override
    void draw(Graphics g) {
        Color birdColor = new Color(random.nextInt(100), random.nextInt(100), random.nextInt(100));
        g.setColor(birdColor);

        int yy = random.nextInt(200);
        g.drawArc(x, yy, birdSize, birdSize / 2, 50, 130);
        g.drawArc(x + 36 * birdSize / 50, yy, birdSize, birdSize / 2, 140, -130);

    }
}