// import javax.swing.*;

// public class testing {
//     public static void main(String[] args) {
//         JFrame frame = new JFrame("My Frame");
//         frame.setSize(400, 300);

//         JButton showButton = new JButton("Show Frame");
//         showButton.addActionListener(e -> {
//             frame.setVisible(true); // Make the frame visible
//         });

//         JButton hideButton = new JButton("Hide Frame");
//         hideButton.addActionListener(e -> {
//             JOptionPane.showMessageDialog(null, "BOBO");
//             frame.setVisible(false); // Hide the frame
//         });

//         JPanel panel = new JPanel();
//         panel.add(showButton);
//         panel.add(hideButton);

//         frame.add(panel);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }
// }
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout; // added code
import java.awt.Component; // added code

public class testing{

public static void main(String[] args) {

    JFrame frame = new JFrame("A Simple GUI");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(500, 500);
    frame.setLocation(430, 100);

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // added code

    frame.add(panel);

    JLabel lbl = new JLabel("Select one of the possible choices and click OK");
    lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
    //lbl.setVisible(true); // Not needed

    panel.add(lbl);

    String[] choices = { "CHOICE 1", "CHOICE 2", "CHOICE 3", "CHOICE 4",
                         "CHOICE 5", "CHOICE 6" };

    final JComboBox<String> cb = new JComboBox<String>(choices);

    cb.setMaximumSize(cb.getPreferredSize()); // added code
    cb.setAlignmentX(Component.CENTER_ALIGNMENT);// added code
    //cb.setVisible(true); // Not needed
    panel.add(cb);

    JButton btn = new JButton("OK");
    btn.setAlignmentX(Component.CENTER_ALIGNMENT); // added code
    panel.add(btn);

    frame.setVisible(true); // added code

    }
}
