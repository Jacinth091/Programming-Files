package Entity;
import Events.KeyInput;
import main.MainPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity{


    protected KeyInput kPut;
    protected MainPanel mp;
    private int animSpeed = 12;

    private final String ws_Res = " ";

//
//    public int screenPosX;
//    public int screenPosX;

    public Player(KeyInput kPut, MainPanel mp){

        this.kPut = kPut;
        this.mp = mp;


        setPlayerDefaults();
    }


    public void setPlayerDefaults(){
        worldXPos = 100;
        worldYPos = 100;
        walkSpd = 5;
        runSpd =0;
        direction = "up";

    }

/*    public BufferedImage playerSprite(){

        BufferedImage sprite = null;

        switch(direction){
            case "down":
                sprite = changeSprite() ? walkingSprites[0] : walkingSprites[1];
                break;
            case "left":
                sprite = changeSprite() ? walkingSprites[2] : walkingSprites[3];
                break;

            case "right":
                sprite = changeSprite() ? walkingSprites[4] : walkingSprites[5];
                break;

            case "up":
                sprite = changeSprite() ? walkingSprites[6] : walkingSprites[7];
                break;
            default:
                System.out.println("There is no assigned sprite to " + direction + " direction");
        }

        return  sprite;
    }*/

    public void getPlayerSprites(){

        File path = new File(ws_Res); // Getting the path of all player sprites
        File[] allSprites = path.listFiles(); // Listing individual files inside the folder path

        assert allSprites != null;
        walking_sprites = new BufferedImage[allSprites.length]; // assigning the length of player walking sprites array

        for(int i = 0; i < allSprites.length; i++){
            BufferedImage tempBuffer;
            try{
                String filePath = allSprites[i].getPath();
                System.out.println(filePath);

//                tempBuffer = ImageIO.read(getClass().getResourceAsStream("\"\\"+filePath+"\""));

                tempBuffer = ImageIO.read(allSprites[i]);

                if(tempBuffer != null){
                    walking_sprites[i] = tempBuffer;
                }
                else{
                    System.out.println("Failed to load image: " + filePath);
                }


            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
    public void spriteAnimationManager(){
        spriteCounter++;

        if(spriteCounter > animSpeed){
            if(spriteNum ==1){
                spriteNum =2;
            }
            else if(spriteNum ==2){
                spriteNum =1;
            }
            spriteCounter =0;
        }
    }
    public void playerMove(){
        if(kPut.upPressed){
            direction = "up";
            worldYPos -= walkSpd;
//            System.out.println("UP");
        }
        else if(kPut.leftPressed){
            direction = "left";
            worldXPos -= walkSpd;
//            System.out.println("left");

        }
        else if(kPut.downPressed){
            direction = "down";
            worldYPos += walkSpd;
//            System.out.println("down");

        }
        else if(kPut.rightPressed){
            direction = "right";
            worldXPos += walkSpd;
//            System.out.println("right");

        }

    }
    public boolean isKeyPressed(){
        return kPut.upPressed || kPut.leftPressed || kPut.rightPressed || kPut.downPressed;
    }
    public boolean changeSprite(){
        boolean value = false;
        if(spriteNum ==1){
            value = true;
        }
        else if( spriteNum ==2){
            value = false;
        }
        return value;
    }



    public void update(){
        if(isKeyPressed()){

            playerMove();
//            System.out.println("Player x: " + worldXPos);
//            System.out.println("Player x: " + worldYPos);

        }
    }

    public void draw(Graphics2D g2){

//        g2.drawImage();
//        g2.drawImage(null, 0, 0 ,tileSize, tileSize, null);
        g2.setColor(Color.white);
        g2.fillRect(worldXPos, worldYPos, mp.tileSize, mp.tileSize);


    }




}
