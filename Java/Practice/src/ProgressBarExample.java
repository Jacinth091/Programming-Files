import javax.swing.*;
import java.awt.*;

public class ProgressBarExample extends JFrame {
    
    private JProgressBar progressBar;

    public ProgressBarExample() {
        // Initialize frame
        setTitle("Progress Bar Example");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize progress bar
        progressBar = new JProgressBar(0, 100);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);  // Show percentage text
        
        // Add the progress bar to the frame
        add(progressBar, BorderLayout.CENTER);
        
        // Example to update progress in a background task
        new Thread(new ProgressUpdater()).start();
    }

    // Background task to simulate progress
    private class ProgressUpdater implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <= 100; i++) {
                final int progress = i;
                SwingUtilities.invokeLater(() -> progressBar.setValue(progress));
                
                // Simulate time-consuming task
                try {
                    Thread.sleep(50);  // Adjust delay as needed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProgressBarExample example = new ProgressBarExample();
            example.setVisible(true);
        });
    }
}
