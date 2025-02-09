import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class PlayerNameInput extends JFrame {
    private JTextField nameTextField;
    private JButton submitButton;
    private boolean isNameEntered = false;  // Flag to track if the name has been entered
    private static String name;

    public PlayerNameInput() {
        // Initialize components
        nameTextField = new JTextField(20);
        submitButton = new JButton("Submit");

        // Set up the frame
        setTitle("Enter Player Name");
        setSize(400, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Enter your name:"));
        add(nameTextField);
        add(submitButton);

        // Add action listeners to handle input
        submitButton.addActionListener(e -> submitName());
        nameTextField.addActionListener(e -> submitName());

        // Display the window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlayerNameInput());
        System.out.println("Hello USER!!: "+ name);
    }

    private void submitName() {
        String playerName = nameTextField.getText();
        if (!playerName.isEmpty()) {
            // Set the flag to true when the name is entered
            isNameEntered = true;
            System.out.println("Player Name Entered: " + playerName);

            // Trigger the CompletableFuture after name is entered
            proceedWithName(playerName);
        }
    }

    private void proceedWithName(String playerName) {
        // CompletableFuture to wait for player input and proceed after
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            while (!isNameEntered) {
                try {
                    // Busy-wait until the name is entered (could use a more efficient approach like CountDownLatch)
                    Thread.sleep(10000);  // Sleep to reduce CPU usage
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            // Proceed with the next step once the player has entered their name
            System.out.println("Proceeding with the game, player: " + playerName);
            name =playerName;
            // You can continue with further game logic here
        });

        // Wait for the task to complete
        future.join(); // This blocks until the `isNameEntered` is set to true
        // Continue with the next action after the name is entered
    }
}


