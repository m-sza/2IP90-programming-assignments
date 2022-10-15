import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.geom.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Timer;
import java.util.Random;

/**
 * Prisoners Dilemma application.
 * 
 * INCOMPLETE
 * 
 * assignment copyright Kees Huizing
 * 
 * @author Matyas Szabolcs
 * @id 1835521
 * @author Quinn Caris
 * @id 1779133
 */
class PrisonersDilemma /* possible extends... */ {
    // ...

    JFrame frame;
    JPanel field;
    JPanel[][] patches;
    JPanel buttonPanel;
    JButton goButton;
    JButton resetButton;
    JSlider defectionAwardSlider;

    
    public void setInitialGrid() {
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                System.out.println(x + "" + y);
                boolean isCooperating = PlayingField.RANDOM.nextBoolean();
                System.out.println(isCooperating);
                if (isCooperating) {
                    patches[x][y].setBackground(new Color(255,255,255));
                }
                else {
                    patches[x][y].setBackground(new Color(0, 0, 0));
                }
            }
        }
    }

    /**
     * Build the GUI for the Prisoner's Dilemma application.
     */
    void buildGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame("Prisoners Dilemma");
                frame.setSize(700, 756);
                frame.setResizable(false);

                // add playingField
                field = new JPanel(new GridLayout(50, 50));
                field.setBackground(Color.black);
                frame.add(field);
                    // add patches
                    patches = new JPanel[50][50];
                    for (int i = 0; i < 50; i++) {
                        for (int j = 0; j < 50; j++) {
                            JPanel patch = new JPanel();
                            patch.setOpaque(true);
                            field.add(patch);
                            patches[j][i] = patch;
                        }
                    }
                    patches[20][20].setBackground(new Color(255,255,255));
                // add buttonPanel
                buttonPanel = new JPanel(new BorderLayout());
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
                buttonPanel.setPreferredSize(new Dimension(100, 40));
                frame.add(buttonPanel, BorderLayout.SOUTH);
                    // add resetButton
                    resetButton = new JButton("RESET");
                    //resetButton.setSize(new Dimension(100, 50));
                    buttonPanel.add(resetButton, BorderLayout.WEST);
                    // add defectionAwardSlider
                    defectionAwardSlider = new JSlider(0);
                    //defectionAwardSlider.setPreferredSize(new Dimension(100, 50));
                    buttonPanel.add(defectionAwardSlider, BorderLayout.NORTH);
                    // add goButton
                    goButton = new JButton("GO");
                    //goButton.setPreferredSize(new Dimension(100, 50));
                    buttonPanel.add(goButton, BorderLayout.EAST);

                frame.setVisible(true);
            }
        });
    }

    public double getAlphaFromDilemma() {
        return defectionAwardSlider.getValue();
    }

    public static void main(String[] a) throws InterruptedException {
        new PrisonersDilemma().buildGUI();

        new PrisonersDilemma().setInitialGrid();

        /*
        // step once every second (not yet implemented)
        ActionListener task = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // step()?
            }
        };
        Timer timer = new Timer(100 ,task);
        timer.start();
        */

    }
}
