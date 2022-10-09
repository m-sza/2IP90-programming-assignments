import java.awt.Graphics;

/**
 * HeptagramDingus is a star with 7 points that will be implemented into the random art picture.
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class HeptagramDingus extends Dingus {
    // initializing a size variable to randomize later
    private int size = 0;

    /**
     * Create and initialize a new CircleDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public HeptagramDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        size = random.nextInt(100) + 30;
    }

    @Override
    void draw(Graphics g) {
        // the y is always reversed because of how Java panel axis works
        g.drawLine(x + size, 
            y, 
            (x + size) + (int) Math.round(size * Math.cos((-5.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((5.0 / 14) * Math.PI)));
        g.drawLine((x + size) + (int) Math.round(size * Math.cos((-5.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((5.0 / 14) * Math.PI)), 
            (x + size) + (int) Math.round(size * Math.cos((11.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((-11.0 / 14) * Math.PI)));
        g.drawLine((x + size) + (int) Math.round(size * Math.cos((11.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((-11.0 / 14) * Math.PI)), 
            (x + size) + (int) Math.round(size * Math.cos((-1.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((1.0 / 14) * Math.PI)));
        g.drawLine((x + size) + (int) Math.round(size * Math.cos((-1.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((1.0 / 14) * Math.PI)), 
            (x + size) + (int) Math.round(size * Math.cos((-13.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((13.0 / 14) * Math.PI)));
        g.drawLine((x + size) + (int) Math.round(size * Math.cos((-13.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((13.0 / 14) * Math.PI)), 
            (x + size) + (int) Math.round(size * Math.cos((3.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((-3.0 / 14) * Math.PI)));
        g.drawLine((x + size) + (int) Math.round(size * Math.cos((3.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((-3.0 / 14) * Math.PI)), 
            (x + size) + (int) Math.round(size * Math.cos((-9.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((9.0 / 14) * Math.PI)));
        g.drawLine((x + size) + (int) Math.round(size * Math.cos((-9.0 / 14) * Math.PI)), 
            (y + size) + (int) Math.round(size * Math.sin((9.0 / 14) * Math.PI)), 
            x + size, 
            y);
    }
}