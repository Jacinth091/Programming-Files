// GamePanel.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private final JTextArea gameLog;
    private Player player;
    private Enemy currentEnemy;
    private final EnemySpawnThread spawnThread;

    public GamePanel() {
        setLayout(new BorderLayout());

        gameLog = new JTextArea();
        gameLog.setEditable(false);
        add(new JScrollPane(gameLog), BorderLayout.CENTER);

        JButton exploreButton = new JButton("Explore");
        exploreButton.addActionListener(e -> performAction(new ExploreAction()));

        JButton fightButton = new JButton("Fight");
        fightButton.addActionListener(e -> performAction(new FightAction()));

        JButton collectButton = new JButton("Collect Item");
        collectButton.addActionListener(e -> performAction(new CollectItemAction()));

        JPanel actionPanel = new JPanel();
        actionPanel.add(exploreButton);
        actionPanel.add(fightButton);
        actionPanel.add(collectButton);
        add(actionPanel, BorderLayout.SOUTH);

        player = new Player("Hero", 100, 20, 10);
        spawnThread = new EnemySpawnThread(this);
        spawnThread.start();
    }

    public void addEnemy(Enemy enemy) {
        currentEnemy = enemy;
        gameLog.append("An enemy has spawned: " + enemy.name + "\n");
    }

    private void performAction(Action action) {
        gameLog.append("Player performs action: " + action.getName() + "\n");
        action.perform();

        if (action instanceof FightAction && currentEnemy != null) {
            fightEnemy();
        }
    }

    private void fightEnemy() {
        int playerDamage = player.attack();
        int enemyDamage = currentEnemy.attack();

        currentEnemy.takeDamage(playerDamage);
        player.takeDamage(enemyDamage);

        gameLog.append("Player deals " + playerDamage + " damage to the enemy.\n");
        gameLog.append("Enemy deals " + enemyDamage + " damage to the player.\n");

        if (!currentEnemy.isAlive()) {
            gameLog.append("Enemy defeated!\n");
            currentEnemy = null;
        } else if (!player.isAlive()) {
            gameLog.append("Player has been defeated!\n");
            spawnThread.stopSpawning();
        }
    }
}
