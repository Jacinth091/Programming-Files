package Entity;

import Main.GameUpdate;
import Main.InputManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {

    GameUpdate gu;
    InputManager input;



    public Player(GameUpdate gu, InputManager input){
        this.gu = gu;
        this.input = input;

        setDefaults();
        getPlayerSprite();
    }

    public void getPlayerSprite(){

        try{

            head = ImageIO.read(getClass().getResourceAsStream("/player/head02.png"));




        }catch(IOException e){
            e.printStackTrace();
        }


    }
    private void setDefaults(){
        playerX = 100;
        playerY = 100;
        speed = 2;
    }

    public void playerMovements(){
        if(input.upPressed){
            playerY -= speed;
            direction = "up";
        }
        else if(input.downPressed){
            playerY += speed;
            direction = "down";

        }
        else if(input.leftPressed){
            playerX -= speed;
            direction = "left";

        }
        else if(input.rightPressed){
            playerX += speed;
            direction = "right";

        }



    }

    public void update(){
        if(input.upPressed || input.leftPressed || input.rightPressed || input.downPressed){
            playerMovements();
        }

    }

    public void drawSprite(Graphics2D g2){
//
        g2.setColor(Color.GREEN);
        g2.fillRect(playerX,playerY, gu.TILE_SIZE, gu.TILE_SIZE);
/*        BufferedImage player = head;

        g2.drawImage(head, playerX, playerY, gu.TILE_SIZE, gu.TILE_SIZE, null);*/

    }



}
