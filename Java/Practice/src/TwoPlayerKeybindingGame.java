import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TwoPlayerKeybindingGame extends JFrame {
    private JLabel questionLabel;
    private JTextArea messageArea;
    private boolean questionAnswered = false; // Prevent multiple answers
    private String correctAnswer = "42"; // Example correct answer

    public TwoPlayerKeybindingGame() {
        // Set up the frame
        setTitle("2-Player Competitive Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        // Question display at the top
        questionLabel = new JLabel("What is the answer to life, the universe, and everything?", JLabel.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(questionLabel, BorderLayout.NORTH);

        // Message area in the center
        messageArea = new JTextArea();
        messageArea.setEditable(false);
        messageArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        add(new JScrollPane(messageArea), BorderLayout.CENTER);

        // Player instructions at the bottom
        JLabel instructions = new JLabel("Player 1: Press 'A' | Player 2: Press 'L'", JLabel.CENTER);
        instructions.setFont(new Font("Arial", Font.ITALIC, 14));
        add(instructions, BorderLayout.SOUTH);

        // Keybindings for Player 1 and Player 2
        setupKeyBindings();

        setVisible(true);
    }

    private void setupKeyBindings() {
        // Player 1 (Key: A)
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "player1Answer");
        getRootPane().getActionMap().put("player1Answer", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePlayerAnswer(1);
            }
        });

        // Player 2 (Key: L)
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("L"), "player2Answer");
        getRootPane().getActionMap().put("player2Answer", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePlayerAnswer(2);
            }
        });
    }

    private void handlePlayerAnswer(int player) {
        if (questionAnswered) return; // Ignore if already answered

        questionAnswered = true; // Mark the question as answered
        String message;

        // Simulate the player's answer (you can replace this with actual input)
        String playerAnswer = JOptionPane.showInputDialog(this, "Player " + player + ", enter your answer:");

        // Check if the answer is correct
        if (correctAnswer.equals(playerAnswer)) {
            message = "Player " + player + " answered correctly! Gained advantage.";
        } else {
            message = "Player " + player + " answered incorrectly! No advantage gained.";
        }

        // Display result
        messageArea.append(message + "\n");

        // Reset or end the game logic
        JOptionPane.showMessageDialog(this, "Press OK to reset the game.");
        resetGame();
    }

    private void resetGame() {
        questionAnswered = false; // Allow new answers
        messageArea.setText(""); // Clear message area
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TwoPlayerKeybindingGame::new);
    }
}
