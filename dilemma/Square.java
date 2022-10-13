import java.awt.*;

/** 
 * Main class for the homework assignment Random Artist.
 * 
 * This class doesn't need to change.
 *  
 * TODO:
 *
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
public class Square {
    private int width = 100;
    private int height = 100;
    private int x;
    private int y;
    private Color color;

    /**
     * shut up.
     * @param x shut
     * @param y shut
     * @param color shut
     */
    public Square(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * shut up.
     */
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
