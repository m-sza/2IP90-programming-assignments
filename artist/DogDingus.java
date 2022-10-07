import java.awt.Graphics;

/**
 * DogDingus is a shape that will be implemented into the random art picture.
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class DogDingus extends Dingus {

    /**
     * Create and initialize a new CircleDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public DogDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
    }

    @Override
    void draw(Graphics g) {
        int[] pixelGridX = new int[20];
        int[] pixelGridY = new int[19];
        int count = 0;
        for (int i = 0; i < 20; i++) {
            pixelGridX[i] = count;
            count = count + 2;
        }
        count = 0;
        for (int i = 0; i < 19; i++) {
            pixelGridY[i] = count;
            count = count + 2;
        }
        g.fillRect(x + pixelGridX[2], y + pixelGridY[0], 2, 2);
        g.fillRect(x + pixelGridX[4], y + pixelGridY[0], 8, 2);
        g.fillRect(x + pixelGridX[9], y + pixelGridY[0], 2, 2);
    }
}