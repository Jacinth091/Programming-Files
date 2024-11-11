// EnemySpawnThread.java
import java.util.Random;

class EnemySpawnThread extends Thread {
    private final GamePanel gamePanel;
    private boolean running = true;

    public EnemySpawnThread(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void stopSpawning() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(5000); // Spawns enemy every 5 seconds
                Enemy enemy = generateRandomEnemy();
                gamePanel.addEnemy(enemy);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private Enemy generateRandomEnemy() {
        Random rand = new Random();
        return new Enemy("Enemy" + rand.nextInt(100), 100, rand.nextInt(20) + 10, rand.nextInt(10) + 5);
    }
}
