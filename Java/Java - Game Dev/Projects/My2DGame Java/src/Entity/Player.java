package Entity;

import Main.GamePanel;
import Main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;  // for the player to be in the center of the screen as the camera moves
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        setDefaultValue();
        getPlayerSprite();
    }

    public void getPlayerSprite(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setDefaultValue(){
//        worldX = gp.tileSize * 8;
//        worldY = gp.tileSize * 10;
        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void update(){

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            if(keyH.upPressed){
                direction = "up";
                worldY -= speed;
            }
            else if(keyH.downPressed){
                direction = "down";
                worldY += speed;

            }
            else if(keyH.leftPressed){
                direction = "left";
                worldX -= speed;
            }
            else if(keyH.rightPressed){
                direction = "right";
                worldX += speed;
            }

            // Clamp player to the world boundaries
            worldX = Math.max(0, Math.min(worldX, gp.worldWidth - gp.tileSize));
            worldY = Math.max(0, Math.min(worldY, gp.worldHeight - gp.tileSize));

            spriteCounter++;
            if(spriteCounter > 10){
                if(spriteNum == 1){
                    spriteNum =2;
                }
                else if(spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }


    }
    public void draw(Graphics2D g2){

//        g2.setColor(Color.green);
//        g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage playerSprite = null;

        switch(direction){
            case "up":
                if(spriteNum == 1){
                    playerSprite = up1;
                }
                else if(spriteNum ==2){
                    playerSprite = up2;
                }
                break;
            case "down":
                if(spriteNum == 1){
                    playerSprite = down1;
                }
                else if(spriteNum ==2){
                    playerSprite = down2;
                }

                break;
            case "left":
                if(spriteNum == 1){
                    playerSprite = left1;
                }
                else if(spriteNum ==2){
                    playerSprite = left2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    playerSprite = right1;
                }
                else if(spriteNum ==2){
                    playerSprite = right2;
                }
                break;

        }
        g2.drawImage(playerSprite, screenX, screenY, gp.tileSize, gp.tileSize, null);


    }



}
