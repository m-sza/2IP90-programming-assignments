import java.awt.Color;
import java.awt.Graphics;


/**
 * PineDingus creates a more complex tree for the randomly generated artpiece.
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class PineDingus extends Dingus {
    private int crownHeight;
    private int crownWidth;
    private int trunkHeight;
    private int trunkWidth;

    /**
     * Create and initialize a new PineDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public PineDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize PineDingus properties
        crownHeight = random.nextInt(maxX / 6) + 20;
        crownWidth = random.nextInt(maxX / 6) + 20;
        trunkHeight = random.nextInt((maxY - 2 * crownWidth) / 2);
        trunkWidth = crownWidth / 4 + 1;
    }

    @Override
    void draw(Graphics g) {
        // draw crown
        Color treeColor = new Color(random.nextInt(100), 
            random.nextInt(150) + 50, 
            random.nextInt(100));
        g.setColor(treeColor);
        
        y = random.nextInt(maxY / 2) + maxY / 4;

        g.fillPolygon(new int[] {x + (crownWidth / 2), x + (crownWidth), x + (3 * crownWidth / 2)}, 
            new int[] {y + (2 * crownHeight), y + (crownHeight), y + (2 * crownHeight)}, 3);
        g.fillPolygon(new int[] {x + (3 * crownWidth / 4), 
            x + (crownWidth), x + (5 * crownWidth / 4)}, 
            new int[] {y + (crownHeight) + 10, 
                y + (1 * crownHeight / 3), 
                y + (crownHeight) + 10}, 3);
        g.fillPolygon(new int[] {x + (9 * crownWidth / 10), 
            x + (crownWidth), 
            x + (11 * crownWidth / 10)}, 
            new int[] {y + (1 * crownHeight / 3) + 10, y, y + (1 * crownHeight / 3) + 10}, 3);

        // draw trunk
        int xx = x + crownWidth - trunkWidth / 2;
        int yy = y + 2 * crownHeight;

        g.drawRect(xx, yy, trunkWidth, trunkHeight);
    }
}