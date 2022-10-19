import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.event.ChangeListener;

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
    static JSlider defectionAwardSlider;
    boolean go = false;

    PlayingField playingField = new PlayingField();

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
                // add buttonPanel
                buttonPanel = new JPanel(new BorderLayout());
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
                buttonPanel.setPreferredSize(new Dimension(100, 40));
                frame.add(buttonPanel, BorderLayout.SOUTH);
                    // add resetButton
                    resetButton = new JButton("RESET");
                    resetButton.setPreferredSize(new Dimension(100, 40));
                    buttonPanel.add(resetButton, BorderLayout.WEST);
                    resetButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            // reset game
                        }
                    });
                    // add defectionAwardSlider
                    defectionAwardSlider = new JSlider(0, 30);
                    buttonPanel.add(defectionAwardSlider, BorderLayout.NORTH);
                    defectionAwardSlider.addChangeListener(new ChangeListener() {
                        public void stateChanged(ChangeEvent e) {
                            defectionAwardSlider.setValue(
                                    Math.round(defectionAwardSlider.getValue())); //snapping
                            System.out.println(
                                "defectionAward: " + defectionAwardSlider.getValue() / 10.0);
                            playingField.alpha = defectionAwardSlider.getValue() / 10.0;
                        }
                    });
                    // add goButton
                    goButton = new JButton("GO");
                    goButton.setPreferredSize(new Dimension(100, 40));
                    buttonPanel.add(goButton, BorderLayout.EAST);
                    goButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (goButton.getText() == "GO") {
                                goButton.setText("PAUSE");
                                go = true;
                            } else {
                                goButton.setText("GO");
                                go = false;
                            }
                        }
                    });
                frame.setVisible(true);
                for (int y = 0; y < 50; y++) {
                    for (int x = 0; x < 50; x++) {
                        if (playingField.grid[y][x].isCooperating()) {
                            patches[y][x].setBackground(new Color(0, 0, 255));
                        } else {
                            patches[y][x].setBackground(new Color(255, 0, 0));
                        }
                    }
                }
            }
        });
    }

    public static double getAlphaFromDilemma() {
        return defectionAwardSlider.getValue() * 0.3 / 10.0;
    }

    /**
     * Defines the loop the simulation goes through when go is true.
     */
    public void loop() {
        while (true) {
            // Don't delete this print statement, for some reason it breaks the code
            System.out.println("");
            if (go) {
                //playingField.setAlpha();
                playingField.step();
                for (int y = 0; y < 50; y++) {
                    for (int x = 0; x < 50; x++) {
                        if (playingField.grid[y][x].isCooperating()) {
                            patches[y][x].setBackground(new Color(0, 0, 255));
                        } else {
                            patches[y][x].setBackground(new Color(255, 0, 0));
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] a) throws InterruptedException {
        new PrisonersDilemma().runMain();
    }

    /**
     * Main run method.
     */
    public void runMain() {
        playingField.setInitialGrid();
        this.buildGUI();
        this.loop();
    }
}
