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

    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
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
        x =100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void update(){

        if(keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed){
            if(keyH.upPressed){
                direction = "up";
                y -= speed;
            }
            else if(keyH.downPressed){
                direction = "down";
                y += speed;

            }
            else if(keyH.leftPressed){
                direction = "left";
                x -= speed;
            }
            else if(keyH.rightPressed){
                direction = "right";
                x += speed;
            }
            spriteCounter++;
            if(spriteCounter > 12){
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
        g2.drawImage(playerSprite, x, y, gp.tileSize, gp.tileSize, null);


    }



}
