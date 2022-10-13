import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.*;
//...

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

    /**
     * Build the GUI for the Prisoner's Dilemma application.
     */
    JFrame frame;
    JTable playingField;

    JPanel buttonPanel;
    JButton goButton;
    JButton resetButton;
    JSlider defectionAwardSlider;

    void buildGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new JFrame("Prisoners Dilemma");
                frame.setSize(800, 785);
                frame.setResizable(false);

                DefaultTableModel model = new DefaultTableModel(50, 50);

                // add playingField
                playingField = new JTable(model);
                playingField.setLayout(new BoxLayout(playingField, BoxLayout.LINE_AXIS));
                playingField.setBackground(Color.blue);
                TableColumnModel columnModel = playingField.getColumnModel();
                for (int i = 0; i < 50; i++) {
                    playingField.setRowHeight(i, 14);
                    columnModel.getColumn(i).setPreferredWidth(10);
                }
                playingField.setPreferredSize(new Dimension(600, 700));
                frame.add(playingField, BorderLayout.NORTH);

                // add buttonPanel
                buttonPanel = new JPanel(new BorderLayout());
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
                buttonPanel.setBackground(Color.black);
                buttonPanel.setPreferredSize(new Dimension(100, 50));
                frame.add(buttonPanel, BorderLayout.SOUTH);
                // add resetButton
                resetButton = new JButton("RESET");
                resetButton.setPreferredSize(new Dimension(100, 50));
                buttonPanel.add(resetButton, BorderLayout.WEST);
                // add defectionAwardSlider
                defectionAwardSlider = new JSlider(0);
                defectionAwardSlider.setPreferredSize(new Dimension(100, 50));
                buttonPanel.add(defectionAwardSlider, BorderLayout.NORTH);
                // add goButton
                goButton = new JButton("GO");
                goButton.setPreferredSize(new Dimension(100, 50));
                buttonPanel.add(goButton, BorderLayout.EAST);

                frame.setVisible(true);
            }
        });
    }

    // ...

    public static void main(String[] a) {
        new PrisonersDilemma().buildGUI();
    }
}