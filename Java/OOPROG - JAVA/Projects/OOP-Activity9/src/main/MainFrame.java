package main;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    public MainFrame(){

    }
    public MainFrame(int width, int height, String title, boolean isResizable, LayoutManager layout, int defCloseOper) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setDefaultCloseOperation(defCloseOper);
        this.setLayout(layout);
        this.setLocationRelativeTo(null);
        this.setResizable(isResizable);

    }

    public JPanel createPanel(Color background, Dimension size, LayoutManager layout, boolean isVisible) {
        JPanel panel = new JPanel();
        panel.setBackground(background);
        panel.setPreferredSize(size);
        panel.setLayout(layout);
        panel.setVisible(isVisible);
        return panel;
    }

    public void addComp(JComponent container, JComponent toAdd, Object constraint){
        container.add(toAdd, constraint);
    }

    public void addComp(JComponent container, JComponent toAdd){
        container.add(toAdd);
    }

    public void addComp(JFrame frame, JComponent toAdd){
        frame.getContentPane().add(toAdd);
        frame.revalidate();  // Revalidate to ensure the layout is updated
        frame.repaint();     // Repaint the frame to refresh the display

    }

    public void addComp(JFrame frame, JComponent toAdd, Object constraint){
        frame.getContentPane().add(toAdd, constraint);
        frame.revalidate();  // Revalidate to ensure the layout is updated
        frame.repaint();     // Repaint the frame to refresh the display
    }



}
