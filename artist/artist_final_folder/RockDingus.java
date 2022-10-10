import java.awt.Color;
import java.awt.Graphics;


/**
 * SunDingus draws a singular sun at the top of the image.
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class RockDingus extends Dingus {
    private int rockSize;

    /**
     * Create and initialize a new SunDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public RockDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize SunDingus properties
        rockSize = random.nextInt(50) + 50;
    }

    @Override
    void draw(Graphics g) {
        int c = random.nextInt(50)+75;
        Color rockColor = new Color(c, c, c);
        g.setColor(rockColor);

        g.fillOval(x, random.nextInt(maxY / 2)+maxY/2, rockSize, 2*rockSize/3);

    }
}