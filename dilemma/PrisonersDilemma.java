import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.geom.*;
import java.awt.geom.RoundRectangle2D;

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
    JPanel playingField;
    JPanel patch;
    JPanel buttonPanel;
    JButton goButton;
    JButton resetButton;
    JSlider defectionAwardSlider;

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
                playingField = new JPanel(new GridLayout(50, 50));
                playingField.setBackground(Color.black);
                frame.add(playingField);

                JPanel[][] patches = new JPanel[50][50];
                for (int i = 0; i < 50; i++) {
                    for (int j = 0; j < 50; j++) {
                        JPanel label = new JPanel();
                    
                        label.setBackground(new Color(255-(i+j)*2,(i)*4,255-(j)*4));
                        label.setOpaque(true);
                        if (i==0 && j == 0) {
                            label.setBackground(new Color(255,255,255));
                        }

                        //try {Thread.sleep(250);} catch (InterruptedException e) {System.out.println(e);}

                        playingField.add(label);
                        patches[j][i] = label;
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

    public static void main(String[] a) {
        new PrisonersDilemma().buildGUI();
    }
}