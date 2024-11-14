import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardLayoutExample {
    private JFrame frame;
    private JPanel uiCardPanel;
    private CardLayout cl;
    private JPanel[] uiCards;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new CardLayoutExample().createAndShowGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("CardLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the CardLayout and panel that holds the cards
        cl = new CardLayout();
        uiCardPanel = new JPanel(cl);

        // Create the cards (JPanel for each card)
        uiCards = new JPanel[5];
        for (int i = 0; i < 5; i++) {
            uiCards[i] = new JPanel();
            uiCards[i].setBackground(new Color((int) (Math.random() * 0x1000000)));  // Random background color
            uiCards[i].add(new JLabel("Card " + (i + 1)));
        }

        // Add the cards to the uiCardPanel
        for (int i = 0; i < uiCards.length; i++) {
            uiCardPanel.add(uiCards[i], "Card " + (i + 1));
        }

        // Add a mouse listener to trigger card switch
        uiCards[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Switch to the "Card 2" when the first card is clicked
                cl.show(uiCardPanel, "Card 2");
            }
        });

        uiCards[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Switch to the "Card 3" when the second card is clicked
                cl.show(uiCardPanel, "Card 3");
            }
        });

        // Set the layout of the main frame and add the uiCardPanel
        frame.setLayout(new BorderLayout());
        frame.add(uiCardPanel, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);
    }
}
