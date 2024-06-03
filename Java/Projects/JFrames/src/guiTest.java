import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class guiTest extends JFrame{

    public static void main(String[] args){

        JFrame frameOne = new JFrame();
        JPanel panel = new JPanel();

        frameOne.setVisible(true);
        frameOne.setResizable(false);
        frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frameOne.setPreferredSize(new Dimension(1920, 1080));

        frameOne.setSize(750, 800);


        panel.setVisible(true);
//        panel.setPreferredSize(new Dimension(500, 500));
        panel.setBackground(Color.red);
        panel.setSize(500,500);

        frameOne.setLayout(null);
        frameOne.add(panel);
    }
}
