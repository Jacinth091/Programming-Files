import javax.swing.*;
import java.awt.*;

public class SmoothPanel extends JPanel implements Runnable{
    private int x = 0;
    private int y = 0;
    private Thread th;
    private int fps = 24;
//     public SmoothPanel() {
//         Timer timer = new Timer(1, e -> {
//             x += 5; // Move component or change state
//             repaint(); // Refresh component
//         });
//         timer.start();
//     }

      public SmoothPanel(){
         setLayout(new BorderLayout());
      
      
        JButton button = new JButton("Click Me");
        button.setBounds(150, 150, 100, 30); // Position and size the button
        add(button, BorderLayout.SOUTH);
            start();
      
      
      
      
      
      
      }
      
      public void start(){
      
         if(th == null){
            th = new Thread(this);
            th.start();
         
         }
      
      
      }      
      
      @Override
      public void run(){
         
         gameLoop();
         
      
      
      }
      
      public void gameLoop(){
        long nanoTime = 1000000000;
        double drawInterval = nanoTime / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        int frameCount = 0;
        long fpsTimer = 0;

        while (th != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            fpsTimer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {

                 x+=1;
                 repaint();
               
               
                delta--;
                frameCount++;
            }

            if (fpsTimer >= nanoTime) {
                System.out.println("FPS: " + frameCount);
                frameCount = 0; // Reset frame count
                fpsTimer = 0;   // Move to the next second
            }
        }
    }
      
      
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw something
        g.setColor(Color.RED);
        g.fillOval(x, y, 20, 20); // Example animated object
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Smooth Animation Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new SmoothPanel());
        frame.setVisible(true);
    }
}
