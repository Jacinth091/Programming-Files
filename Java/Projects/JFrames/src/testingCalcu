import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.IsoFields;

public class testingCalcu {
    // public static ArrayList<String> data = new ArrayList<>();
//     public static void main(String[] args) {
//         JFrame frame = new JFrame();
// 
//         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         frame.setSize(500, 500);
//         frame.setTitle("FlowLayout Manager");
//         frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
// 
//         JPanel panel = new JPanel();
//         panel.setPreferredSize(new Dimension(250, 250));
//         panel.setBackground(Color.LIGHT_GRAY);
//         panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
// 
//         for (int i = 1; i <= 10; i++) {
//             JButton button = new JButton(Integer.toString(i));
//             button.addActionListener(new ButtonClickListener());
//             panel.add(button);
//         }
// 
//         frame.add(panel);
//         frame.setVisible(true);
// 
//     }
// 
//     private static class ButtonClickListener implements ActionListener {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//             JButton sourceButton = (JButton) e.getSource();
// //            System.out.println("Button Clicked: " + sourceButton.getText());
//             String data = sourceButton.getText();
//             getData(data);
//             displayList();
// 
// 
// 
// //            JOptionPane.showMessageDialog(null, "Button clicked: " + buttonText);
//             // You can perform any other actions based on the button clicked
//         }
//     }
//     public static int add(int num1, int num2){
//         return num1 + num2;
//     }
//     public static void getData(String localData){
//         data.add(localData);
// 
// 
//     }
//     public static void displayList(){
//         for(byte i = 0; i < data.size(); i++){
//             System.out.printf("%s, ", data.get(i));
//         }
//         System.out.println();


      
      public static void main(String[] args){
         Frame frame = new Frame();
      
 

         
      }

    
      
      


}

class Frame extends JFrame{
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
         button.addActionListener(new ButtonClickListener());
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
   class ButtonClickListener implements ActionListener {


      @Override
      public void actionPerformed(ActionEvent e) {
         JButton sourceButton = (JButton) e.getSource();
         String data = sourceButton.getText();
         label.setText(data);

         
         
//          System.out.printf("Text: %s\n", data);
         
//              getData(data);
//              displayList();
 

      }
}

   
   

}
