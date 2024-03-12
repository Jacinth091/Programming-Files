import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtons {
    public static void main(String[] args) {
        new myFrame();
    }
}
class myFrame extends JFrame implements ActionListener {
    JButton button;
    JLabel label;
    myFrame(){
        ImageIcon image = new ImageIcon("emo.png");
        ImageIcon imageTwo = new ImageIcon("face-shocked.png");


        label = new JLabel();
        label.setIcon(imageTwo);
        label.setBounds(120,200, 250,100);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setVerticalAlignment(label.CENTER);
        label.setHorizontalAlignment(label.CENTER);
        label.setIconTextGap(5);
        label.setFont(new Font("Comic Sans", Font.BOLD, 20));

        label.setBackground(Color.black);
        label.setForeground(Color.white);
        label.setBorder(BorderFactory.createEtchedBorder());
        label.setOpaque(true);
        label.setText("WOAAAAA");
        label.setVisible(false);


        button = new JButton();
        button.setBounds(120,100, 250,100);
        button.addActionListener(this);
        button.setText("Press ME!!");
        button.setFocusable(false);
        button.setIcon(image);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setFont(new Font("Comic Sans", Font.BOLD, 15));
        button.setIconTextGap(-10);
        button.setForeground(Color.cyan);
        button.setBackground(Color.gray);
        button.setBorder(BorderFactory.createEtchedBorder());
//        button.setEnabled(false);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);
        this.add(label);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Hello!");
            label.setVisible(true);
        }
    }

}

// Not using a Lambda Expression

/*class myFrame extends JFrame implements ActionListener {
    JButton button;
    myFrame(){

        button = new JButton();
        button.setBounds(200,100, 100,50);
        button.addActionListener(this);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("Hello!");
        }
    }
}*/
