import java.awt.Graphics;

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
class PineDingus extends Dingus {
    private int crownHeight;
    private int crownWidth;
    private int trunkHeight;
    private int trunkWidth;
    private boolean filled; // true: filled; false: outline

    /**
     * Create and initialize a new TreeDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public PineDingus(int maxX, int maxY) {
        // initialize Dingus properties
        super(maxX, maxY);

        // initialize PineDingus properties
        crownHeight = random.nextInt(maxX / 4);
        crownWidth = random.nextInt(maxX / 4);
        trunkHeight = random.nextInt((maxY - 2 * crownWidth) / 2);
        trunkWidth = crownWidth / 3 + 1;
        filled = random.nextBoolean();
    }

    @Override
    void draw(Graphics g) {
        // draw crown
        g.setColor(color);
        if (filled) {
            // more general way to draw an oval than with fillOval (hint :-)
           g.drawPolygon(new int[] {x+(crownWidth/2), x+(crownWidth), x+(3*crownWidth/2)}, new int[] {y+(2*crownHeight), y+(crownHeight), y+(2*crownHeight)}, 3);
           g.drawPolygon(new int[] {x+(3*crownWidth/4), x+(crownWidth), x+(5*crownWidth/4)}, new int[] {y+(crownHeight), y+(1*crownHeight/3), y+(crownHeight)}, 3);
           g.drawPolygon(new int[] {x+(9*crownWidth/10), x+(crownWidth), x+(11*crownWidth/10)}, new int[] {y+(1*crownHeight/3), y, y+(1*crownHeight/3)}, 3);
        } else {
            g.fillPolygon(new int[] {x+(crownWidth/2), x+(crownWidth), x+(3*crownWidth/2)}, new int[] {y+(2*crownHeight), y+(crownHeight), y+(2*crownHeight)}, 3);
            g.fillPolygon(new int[] {x+(3*crownWidth/4), x+(crownWidth), x+(5*crownWidth/4)}, new int[] {y+(crownHeight)+10, y+(1*crownHeight/3), y+(crownHeight)+10}, 3);
            g.fillPolygon(new int[] {x+(9*crownWidth/10), x+(crownWidth), x+(11*crownWidth/10)}, new int[] {y+(1*crownHeight/3)+10, y, y+(1*crownHeight/3)+10}, 3);
        }

        // draw trunk
        g.setColor(color);
        int xx = x + crownWidth - trunkWidth / 2;
        int yy = y + 2 * crownHeight;

        if (filled) {
            g.fillRect(xx, yy, trunkWidth, trunkHeight);
        } else {
            g.drawRect(xx, yy, trunkWidth, trunkHeight);
        }
    }
}