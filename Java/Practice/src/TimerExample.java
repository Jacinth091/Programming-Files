import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerExample extends JFrame {

    private JLabel timerLabel;
    private int elapsedSeconds = 0;

    public TimerExample() {
        setTitle("Timer Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize the timer label
        timerLabel = new JLabel("00:00", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 40));
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setOpaque(true);
        timerLabel.setBackground(Color.BLACK);
        
        add(timerLabel, BorderLayout.CENTER);

        // Set up the Timer to update the label every second
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedSeconds++;
                updateTimerLabel();
            }
        });

        timer.start();  // Start the timer
    }

    private void updateTimerLabel() {
        int minutes = elapsedSeconds / 60;
        int seconds = elapsedSeconds % 60;
        String timeStr = String.format("%02d:%02d", minutes, seconds);
        timerLabel.setText(timeStr);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TimerExample timerExample = new TimerExample();
            timerExample.setVisible(true);
        });
    }
}
