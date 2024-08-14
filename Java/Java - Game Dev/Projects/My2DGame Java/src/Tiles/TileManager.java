package Tiles;

import Main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tiles;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tiles = new Tile[10];
        getTileImage();
    }
    public void getTileImage(){

    }
}
