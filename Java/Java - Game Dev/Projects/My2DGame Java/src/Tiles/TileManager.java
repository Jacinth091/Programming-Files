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

        mapTileData = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("/maps/sampleMap.txt");
    }

    public void loadMap(String filePath){

        try {
            InputStream is = getClass().getResourceAsStream(filePath);
//            assert is != null;
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col =0, row =0;

            while(col < gp.maxScreenCol && row < gp.maxScreenRow){

                String line = br.readLine();

                while(col < gp.maxScreenCol){
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileData[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
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
            // Grass Tile Sprite
            tiles[0] = new Tile();
            tiles[0].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            // Water Tile Sprite
            tiles[1] = new Tile();
            tiles[1].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));

            // Wall Tile Sprite
            tiles[2] = new Tile();
            tiles[2].tileImage = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){

//        g2.drawImage(tiles[2].tileImage, 0, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tiles[0].tileImage, 48, 0, gp.tileSize, gp.tileSize, null);
//        g2.drawImage(tiles[1].tileImage, 96, 0, gp.tileSize, gp.tileSize, null);

        int col =0;
        int row =0;
        int x =0;
        int y =0;

        while(col < gp.maxScreenCol && row < gp.maxScreenRow){

            int tileIndex = mapTileData[col][row];

            g2.drawImage(tiles[tileIndex].tileImage, x,y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col =0;
                x =0;
                row++;
                y += gp.tileSize;
            }

        }

    }
}
