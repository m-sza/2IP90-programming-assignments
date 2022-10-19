import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Random;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

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
     * Shows the colours for the GUI.
     */
    public void initialGrid() {
        for (int x = 0; x < 50; x++) {
            for (int y = 0; y < 50; y++) {
                // System.out.println(x + "" + y);
                // boolean isCooperating = PlayingField.RANDOM.nextBoolean();
                // System.out.println(isCooperating);
                // if (PlayingField.grid[y][x].isCooperating()) {
                //     patches[x][y].setBackground(new Color(255, 255, 255));
                // } else {
                //     patches[x][y].setBackground(new Color(0, 0, 0));
                // }
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
                            defectionAwardSlider.setValue(Math.round(defectionAwardSlider.getValue())); //snapping
                            System.out.println("defectionAward: " + defectionAwardSlider.getValue() / 10.0);
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

    public void loop() {
        while (true) {
            // Don't delete this print statement, for some reason it breaks the code
            System.out.println("");
            if (go) {
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
                // Timer timer = new Timer(100, task);
                // timer.start();
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

    public void runMain() {
        playingField.setInitialGrid();
        this.buildGUI();
        this.loop();
    }
}
