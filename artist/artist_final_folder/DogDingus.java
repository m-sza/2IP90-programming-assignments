import java.awt.Graphics;

/**
 * DogDingus is a pixel art of a dog that will only be shown once on the field.
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class DogDingus extends Dingus {
    // initializing a size variable to randomize later
    private int size = 0;

    /**
     * Create and initialize a new DogDingus.
     * 
     * @param maxX upper bound for the x coordinate of the position
     * @param maxY upper bound for the y coordinate of the position
     */
    public DogDingus(int maxX, int maxY) {
        // intialize randomly the Dingus properties, i.e., position and color
        super(maxX, maxY);
        size = random.nextInt(1) + 2;
    }

    @Override
    void draw(Graphics g) {
        // initializing a pixel grid to make drawing the "pixels" easier
        int[] pixelGridX = new int[20];
        int[] pixelGridY = new int[19];
        int count = 0;
        y = random.nextInt(300) + 200;
        for (int i = 0; i < 20; i++) {
            pixelGridX[i] = count;
            count = count + size;
        }
        count = 0;
        for (int i = 0; i < 19; i++) {
            pixelGridY[i] = count;
            count = count + size;
        }
        // drawing the dog
        g.fillRect(x + pixelGridX[2], y + pixelGridY[0], size, size);
        g.fillRect(x + pixelGridX[4], y + pixelGridY[0], 4 * size, size);
        g.fillRect(x + pixelGridX[9], y + pixelGridY[0], size, size);
        g.fillRect(x + pixelGridX[1], y + pixelGridY[1], size, 3 * size);
        g.fillRect(x + pixelGridX[3], y + pixelGridY[1], size, size);
        g.fillRect(x + pixelGridX[8], y + pixelGridY[1], size, size);
        g.fillRect(x + pixelGridX[10], y + pixelGridY[1], size, 2 * size);
        g.fillRect(x + pixelGridX[0], y + pixelGridY[4], size, 10 * size);
        g.fillRect(x + pixelGridX[3], y + pixelGridY[4], size, size);
        g.fillRect(x + pixelGridX[6], y + pixelGridY[4], size, size);
        g.fillRect(x + pixelGridX[11], y + pixelGridY[3], size, size);
        g.fillRect(x + pixelGridX[12], y + pixelGridY[4], size, size);
        g.fillRect(x + pixelGridX[13], y + pixelGridY[5], 2 * size, size);
        g.fillRect(x + pixelGridX[15], y + pixelGridY[6], 3 * size, size);
        g.fillRect(x + pixelGridX[17], y + pixelGridY[4], size, 2 * size);
        g.fillRect(x + pixelGridX[18], y + pixelGridY[3], size, size);
        g.fillRect(x + pixelGridX[19], y + pixelGridY[4], size, 9 * size);
        g.fillRect(x + pixelGridX[4], y + pixelGridY[6], 2 * size, size);
        g.fillRect(x + pixelGridX[2], y + pixelGridY[7], size, size);
        g.fillRect(x + pixelGridX[4], y + pixelGridY[7], size, size);
        g.fillRect(x + pixelGridX[7], y + pixelGridY[7], size, size);
        g.fillRect(x + pixelGridX[3], y + pixelGridY[8], 4 * size, size);
        g.fillRect(x + pixelGridX[1], y + pixelGridY[14], size, 3 * size);
        g.fillRect(x + pixelGridX[2], y + pixelGridY[17], size, size);
        g.fillRect(x + pixelGridX[3], y + pixelGridY[16], size, size);
        g.fillRect(x + pixelGridX[4], y + pixelGridY[15], 2 * size, size);
        g.fillRect(x + pixelGridX[5], y + pixelGridY[16], size, 2 * size);
        g.fillRect(x + pixelGridX[6], y + pixelGridY[18], size, size);
        g.fillRect(x + pixelGridX[7], y + pixelGridY[17], size, size);
        g.fillRect(x + pixelGridX[8], y + pixelGridY[16], size, size);
        g.fillRect(x + pixelGridX[8], y + pixelGridY[15], 4 * size, size);
        g.fillRect(x + pixelGridX[11], y + pixelGridY[16], size, 2 * size);
        g.fillRect(x + pixelGridX[12], y + pixelGridY[18], size, size);
        g.fillRect(x + pixelGridX[13], y + pixelGridY[17], size, size);
        g.fillRect(x + pixelGridX[14], y + pixelGridY[16], 2 * size, size);
        g.fillRect(x + pixelGridX[14], y + pixelGridY[15], 2 * size, size);
        g.fillRect(x + pixelGridX[16], y + pixelGridY[17], size, size);
        g.fillRect(x + pixelGridX[17], y + pixelGridY[16], size, size);
        g.fillRect(x + pixelGridX[18], y + pixelGridY[13], size, 3 * size);
    }
}