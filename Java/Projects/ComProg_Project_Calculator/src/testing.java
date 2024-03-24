import javax.swing.*;

public class testing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");
        frame.setSize(400, 300);

        JButton showButton = new JButton("Show Frame");
        showButton.addActionListener(e -> {
            frame.setVisible(true); // Make the frame visible
        });

        JButton hideButton = new JButton("Hide Frame");
        hideButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "BOBO");
            frame.setVisible(false); // Hide the frame
        });

        JPanel panel = new JPanel();
        panel.add(showButton);
        panel.add(hideButton);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
