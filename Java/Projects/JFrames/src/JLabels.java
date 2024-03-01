import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import javax.swing.ImageIcon;



import java.awt.*;

public class JLabels {
    public static void main(String[] args) {

//        MyFrame frame = new MyFrame();

        ImageIcon image = new ImageIcon("minecwaft.png");
        Border border = BorderFactory.createLineBorder(Color.green, 5);

        JLabel label  = new JLabel();
        // Other way to set text of label
        label.setText("Hwllo World!");
        label.setIcon(image);

        // set text LEFT,CENTER, RIGHT, of Image Icon
        label.setHorizontalTextPosition(JLabel.CENTER);

        // Set text  TOP,BOTTOM,CENTER of Image Icon
        label.setVerticalTextPosition(JLabel.TOP);

        // Set font color to the preset colors
        label.setForeground(Color.red);

        // Set the font styling
        // new Font() = creates custom font to use
        label.setFont(new Font("Calibri", Font.BOLD, 15));

        // Set gap between image and the text
        label.setIconTextGap(10);

        // Set the bakcground color for the label
        label.setBackground(Color.black);
        // Setting the visibility of the background of the label
        label.setOpaque(true);

        // set border
        label.setBorder(border);

        // set the position of the label in the frame
        label.setVerticalAlignment(label.CENTER);
        label.setHorizontalAlignment(label.CENTER);


        // setting the bounds for the label to display in the frame
        // set the x and y position within the frame as well as the dimensions
        //label.setBounds(100, 100, 250, 250);



        // Set custom color for the text
        // label.setForeground(new Color(0x00000);
        // label.setForeground(new Color(0, 0, 0));


        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(label);
        // sets the default layout manager to false
       // frame.setLayout(null);

        // Accommodates the frame to the contents
//        frame.pack();








    }
}
