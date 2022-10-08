import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Painting.
 * 
 * Paint with Dinguses, i.e., generate a new painting by making a random 
 * composition of Dingus shapes.
 *
 * TODO:
 *
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
public class Painting extends JPanel implements ActionListener {

    /*---- Randomness ----*/

    /**
     * Seed for the random number generator.
     * 
     * You can change the variable SEED if you like. The same program with the same
     * SEED will generate exactly the same sequence of pictures.
     */
    static final long SEED = 37;

    // DON'T CHANGE the following three lines:
    // RANDOM is the random number generator used and shared by all classes in your program.
    static final Random RANDOM = new Random(SEED);
    int numberOfRegenerates = 0;

    // ---- Screenshots ----
    // DON'T CHANGE the following two lines:
    char current = '0';
    String filename = "randomshot_"; // prefix

    /*---- Dinguses ----*/
    ArrayList<Dingus> shapes;
    // ...

    /**
     * Create a new painting.
     */
    public Painting() {
        setPreferredSize(new Dimension(800, 450)); // make panel 800 by 450 pixels.
        // ...
    }
    
    @Override
    protected void paintComponent(Graphics g) { // draw all your shapes
        super.paintComponent(g); // clears the panel
        // draw all shapes
        for (int i = 0; i < ArrayOfDinguses.size(); i++) {
            ((Dingus) ArrayOfDinguses.get(i)).draw(g);
        }
        // TODO
    }

    /**
     * Reaction to button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ("Regenerate".equals(e.getActionCommand())) {
            regenerate();
            repaint();
        } else { // screenshot
            saveScreenshot(this, filename + current++); // ++ to show of compact code :-)
        }
    }

    // Arraylist for Dinguses
    ArrayList <Object> ArrayOfDinguses = new ArrayList<Object>();

    /**
     * Regenerate this painting.
     */
    void regenerate() {
        numberOfRegenerates++; // do not change

        // clear the shapes list
        ArrayOfDinguses.clear();
        // create random shapes
        for (int i = 0; i < 20; i++) {
            ArrayOfDinguses.add(new PineDingus(800, 450));
        }
    }

    /**
     * Saves a screenshot of this painting to disk.
     * 
     * DON'T CHANGE this method
     * 
     * Note. This action will overide existing files!
     *
     * @param component Component to be saved
     * @param name      filename of the screenshot, followed by a sequence number
     * 
     */
    void saveScreenshot(Component component, String name) {
        // minus 1 because the initial picture should not count
        String randomInfo = "" + SEED + "+" + (numberOfRegenerates - 1);
        System.out.println(SwingUtilities.isEventDispatchThread());
        BufferedImage image = new BufferedImage(
                component.getWidth(),
                component.getHeight(),
                BufferedImage.TYPE_INT_RGB);

        // call the Component's paint method, using
        // the Graphics object of the image.
        Graphics graphics = image.getGraphics();
        component.paint(graphics); // alternately use .printAll(..)
        graphics.drawString(randomInfo, 0, component.getHeight());

        try {
            ImageIO.write(image, "PNG", new File(name + ".png"));
            System.out.println("Saved screenshot as " + name);
        } catch (IOException e) {
            System.out.println("Saving screenshot failed: " + e);
        }
    }
}