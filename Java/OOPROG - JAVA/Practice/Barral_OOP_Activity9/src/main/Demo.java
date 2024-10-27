package main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Demo {

    private void createAndShowGUI() {

        final JPanel cardPanel = new JPanel(new CardLayout());
        cardPanel.add(new Page(), "1");

        final JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardPanel.add(new Page(), String.valueOf(cardPanel.getComponentCount() + 1));
                CardLayout layout = (CardLayout)cardPanel.getLayout();
                layout.next(cardPanel);
            }
        });

        final JButton finishButton = new JButton("Finish");
        finishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextButton.setEnabled(false);
                for(Component comp : cardPanel.getComponents()) {
                    if(comp instanceof Page) {
                        Page page = (Page)comp;
                        page.printData();
                    }
                }
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(nextButton);
        buttonsPanel.add(finishButton);

        JFrame frame = new JFrame("Demo");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    class Page extends JPanel {

        final private JTextField data;

        public Page() {
            super();
            add(new JLabel("Please add some info:"));
            data = new JTextField(20);
            add(data);
        }

        public void printData() {
            System.out.println(data.getText());
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Demo().createAndShowGUI();
            }
        });
    }
}
