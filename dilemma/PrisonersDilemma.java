import java.awt.*;
import java.awt.Color;
import javax.swing.*;
//...

/**
 * Prisoners Dilemma application.
 * 
 * INCOMPLETE
 * 
 * assignment copyright Kees Huizing
 * 
 * @author NAME
 * @id ID
 * @author NAME
 * @id ID
 */
class PrisonersDilemma {
    // ...

    /**
     * Build the GUI for the Prisoner's Dilemma application.
     */
    void buildGUI() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ignore my inferior programming skills");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 300);
            JPanel bigPanel = new JPanel();
            JPanel gridPanel = new JPanel();
            JButton reset = new JButton("Reset");
            JButton go = new JButton("Go");
            frame.add(bigPanel);
            bigPanel.add(gridPanel);
            bigPanel.add(reset);
            bigPanel.add(go);
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 50; j++) {
                    gridPanel.add(new Square(0, 0, Color.BLUE));
                }
            }
            gridPanel.setBackground(Color.RED);
            gridPanel.setLayout(new GridLayout(50, 50));
            frame.setVisible(true);
        });
    }

    // ...

    public static void main(String[] a) {
        new PrisonersDilemma().buildGUI();
    }
}