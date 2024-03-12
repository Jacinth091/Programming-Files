import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.IsoFields;

public class testing {
    public static ArrayList<String> data = new ArrayList<>();
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("FlowLayout Manager");
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 200));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        for (int i = 1; i <= 10; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel);
        frame.setVisible(true);

    }

    private static class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
//            System.out.println("Button Clicked: " + sourceButton.getText());
            String data = sourceButton.getText();
            getData(data);
            displayList();



//            JOptionPane.showMessageDialog(null, "Button clicked: " + buttonText);
            // You can perform any other actions based on the button clicked
        }
    }
    public static int add(int num1, int num2){
        return num1 + num2;
    }
    public static void getData(String localData){
        data.add(localData);


    }
    public static void displayList(){
        for(byte i = 0; i < data.size(); i++){
            System.out.printf("%s, ", data.get(i));
        }
        System.out.println();
    }
}
