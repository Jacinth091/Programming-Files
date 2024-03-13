import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class displayWindow {
    public static void main(String[] args) {



        LaunchPage launchPage = new LaunchPage();
        System.out.println("Hiii");


    }
}

class LaunchPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton button = new JButton("Click Me!");

    LaunchPage(){
        button.setBounds(120, 200, 250, 40);
        button.setFocusable(false);
        button.addActionListener(this);

        frame.add(button);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLayout(null);
        frame.setVisible(true);



    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button){
            frame.dispose();
            NewWindow myWindow = new NewWindow();

        }

    }
}
class NewWindow{
    JFrame newFrame = new JFrame();
    JLabel newLabel = new JLabel("HELLOO!");



    NewWindow(){

        newLabel.setBounds(0,0,200,50);
        newLabel.setFont(new Font(null, Font.BOLD,25));


        newFrame.add(newLabel);
        newFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        newFrame.setSize(new Dimension(500, 500));
        newFrame.setLayout(null);
        newFrame.setVisible(true);
    }
}
