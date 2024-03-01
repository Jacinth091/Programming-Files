import javax.swing.*;

public class JFrames extends JFrame {
    JFrames(){

        // Creates an instance of a JFrame Class


        // Sets the visibility of the frame to be "true"
        this.setVisible(true);

        // Sets the width and height of the frame
        this.setSize(500, 500);

        // Sets the Title
        this.setTitle("JFrame Java Tutorial :D");

        // Sets the frame program to close when the 'X' button is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Prevents the user to re-size the frame window
        this.setResizable(false);

        // Creates an Image Icon
        ImageIcon image = new ImageIcon("minecwaft.png");

        // Change the icon of the frame
        this.setIconImage(image.getImage());

//        // Change the color of the frame
//        this.getContentPane().setBackground(Color.DARK_GRAY);

        // Change the color of the frame using custom rgb
//        this.getContentPane().setBackground(new Color(123, 23, 219));

        // Change the color of the frame using custom hex code
//        this.getContentPane().setBackground(new Color(0xA8B1DB));


    }
}
