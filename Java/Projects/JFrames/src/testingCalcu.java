import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.IsoFields;

public class testingCalcu {
   public static void main(String[] args){
      Frame frame = new Frame();




   }

}

class Frame extends JFrame implements ActionListener{
   JFrame frame;
   JPanel panel, panel1;
   JLabel label;

   Frame(){
      
      panel = new JPanel();
      
      panel.setBackground(Color.gray);
      panel.setPreferredSize(new Dimension(250, 250));
      panel.setLayout(new GridLayout(4,4,10 ,10));
      
      panel1 = new JPanel();
      
      panel1.setBackground(Color.gray);
      panel1.setPreferredSize(new Dimension(250, 100));
      panel1.setLayout(new BorderLayout(10, 10));
      
      
      label = new JLabel();
      
      label.setPreferredSize(new Dimension(240, 95));
      label.setBackground(Color.white);
      label.setOpaque(true);

   
      for(byte i = 0; i < 10; i++){
         JButton button = new JButton(Integer.toString(i));
         button.addActionListener(this);
         panel.add(button);
         
      }

   
      panel1.add(label);
      this.add(panel1);
      this.add(panel);
   
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setSize(500, 500);
      this.setTitle("FlowLayout Manager");
      this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
      this.setVisible(true);

   
   }
   void addText(JButton buttonData){
     
      
       label.setText(buttonData.getText());
      
   
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JButton sourceButton = (JButton) e.getSource();
      String data = sourceButton.getText();
      label.setText(data);


   }
/*   class ButtonClickListener implements ActionListener {



   }*/

}

