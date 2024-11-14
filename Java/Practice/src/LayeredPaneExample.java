import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LayeredPaneExample {
    private JFrame frame;
    private JLayeredPane layeredPane;
    private JPanel panel1, panel2;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new LayeredPaneExample().createAndShowGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Layered Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        layeredPane = new JLayeredPane();
        frame.add(layeredPane);

        // Create two panels for layering
        panel1 = createPanel("Panel 1");
        panel2 = createPanel("Panel 2");

        panel1.setBounds(50, 50, 300, 200);  // Position panel 1
        panel2.setBounds(50, 50, 300, 200);  // Position panel 2

        layeredPane.add(panel1, JLayeredPane.DEFAULT_LAYER);  // Add panel1 to the default layer
        layeredPane.add(panel2, JLayeredPane.PALETTE_LAYER);  // Add panel2 to a higher layer

        // Add mouse listener to switch layers
        panel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel();
            }
        });
        
         panel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                switchPanel();
            }
        });

        frame.setVisible(true);
    }

    private JPanel createPanel(String panelName) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color((int) (Math.random() * 0x1000000)));
        panel.add(new JLabel(panelName));
        return panel;
    }

    private void switchPanel() {
        // Swap visibility by changing the order in the layered pane
        if (panel1.isVisible()) {
            panel1.setVisible(false);
            panel2.setVisible(true);
        } else {
            panel1.setVisible(true);
            panel2.setVisible(false);
        }
    }
}

