import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

import java.awt.*;


public class JPanels {
    public static void main(String[] args) {

        ImageIcon image = new ImageIcon("minecwaft.png");

        JLabel label = new JLabel();
        label.setText("YUDIPUTAAAA");
        label.setIcon(image);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        JPanel redPanel = new JPanel();
        redPanel. setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);
//        redPanel.add(label);

        JPanel bluePanel = new JPanel();
        bluePanel. setBackground(Color.blue);
        bluePanel.setBounds(250, 0, 250, 250);
//        bluePanel.add(label);

        JPanel greenPanel = new JPanel();
        greenPanel. setBackground(Color.green);
        greenPanel.setBounds(0, 250, 500, 250);
//        greenPanel.add(label);
        greenPanel.setLayout(new BorderLayout());

        JPanel yellowPanel = new JPanel();
        yellowPanel. setBackground(Color.yellow);
        yellowPanel.setBounds(500, 0, 250, 500);


        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(750, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(redPanel);
        frame.add(bluePanel);
        frame.add(greenPanel);
        frame.add(yellowPanel);
        greenPanel.add(label);






    }
}
