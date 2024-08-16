package Tiles;

import Main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tiles;

    int[][] mapTileData;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tile[10];

        mapTileData = new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/maps/world01.txt");
    }

    public void loadMap(String filePath){

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
//            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col =0, row =0;

            while(col < gp.maxWorldCol && row < gp.maxWorldRow){

                String line = br.readLine();

                while(col < gp.maxWorldCol){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileData[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol){
                    col = 0;
                    row++;
                }

            }
            br.close();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void getTileImage(){

        try {

            String[] tileID = {"grass", "wall", "water",  "earth", "tree", "sand"};
            // Grass Tile Sprite

            for(int i =0; i< tileID.length; i++){
                tiles[i] = new Tile();
                tiles[i].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/" + tileID[i] +".png"));
            }
//            tiles[0] = new Tile();
//            tiles[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
//
//            // Water Tile Sprite
//            tiles[1] = new Tile();
//            tiles[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
//
//            // Wall Tile Sprite
//            tiles[2] = new Tile();
//            tiles[2].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileIndex = mapTileData[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;

            int screenX = (worldX - gp.player.worldX)+ gp.player.screenX;
            int screenY = (worldY - gp.player.worldY) + gp.player.screenY;

            // Ensure that only tiles within the screen bounds are drawn
            if (screenDrawBounds(worldX, worldY)) {

                g2.drawImage(tiles[tileIndex].tileImage, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }




    public boolean screenDrawBounds(int worldX, int worldY) {
        return worldX + gp.tileSize>  gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX +  gp.player.screenX &&
                worldY + gp.tileSize> gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY;




    }

}
