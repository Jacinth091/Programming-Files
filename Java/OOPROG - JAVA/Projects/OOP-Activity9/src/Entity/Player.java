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
        worldXPos = (mp.screenWidth/ 2) - (mp.tileSize/2);
        worldYPos = ((mp.screenHeight / 2) - (mp.tileSize/2)) + (mp.screenHeight / 3);
        plyVelocity = 10;
        runSpd =0;
        direction = "up";
        dirX =0;
        dirY = 0;

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


    public void update(){
        if(isKeyPressed()){
            entityMove();
            checkOutOfBounds();
            getCoordinates();

        }
    }

    public void draw(Graphics2D g2){

//        g2.drawImage();
//        g2.drawImage(null, 0, 0 ,tileSize, tileSize, null);
        g2.setColor(Color.white);
        g2.fillRect(worldXPos, worldYPos, mp.tileSize, mp.tileSize);


    }


    @Override
    public void getCoordinates(){
        System.out.println("X: " + worldXPos + " Ydsds: " + worldYPos);
        System.out.println();
    }


    @Override
    public void checkOutOfBounds() {
        // Correct for left and right boundaries
        if (worldXPos <= 0) {
            worldXPos = 0; // Prevent player from moving out on the left
        }
        else if (worldXPos + mp.tileSize >= mp.screenWidth) {
            worldXPos = mp.screenWidth - mp.tileSize; // Prevent player from moving out on the right
        }

        // Correct for top and bottom boundaries
        if (worldYPos <= 0) {
            worldYPos = 0; // Prevent player from moving out on the top
        }
        else if (worldYPos + mp.tileSize >= mp.screenHeight) {
            worldYPos = mp.screenHeight - mp.tileSize; // Prevent player from moving out on the bottom
        }
    }

    @Override
    public void getSprites(){

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


    @Override
    public void entityMove(){
        if(kPut.upPressed){
            direction = "up";
            dirY = -1;
            worldYPos -= plyVelocity;
//            System.out.println("UP");
        }
        else if(kPut.leftPressed){
            direction = "left";
            dirX = -1;
            worldXPos -= plyVelocity;
//            System.out.println("left");

        }
        else if(kPut.downPressed){
            direction = "down";
            worldYPos += plyVelocity;
            dirY = 1;
//            System.out.println("down");

        }
        else if(kPut.rightPressed){
            direction = "right";
            dirX = 1;
            worldXPos += plyVelocity;
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


}
