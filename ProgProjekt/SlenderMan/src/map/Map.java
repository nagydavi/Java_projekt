package map;

import Slenderman.Handler;
import tiles.Tile;
import utils.Util;

import java.awt.*;
/**
 * Map class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * A pálya betöltése és létrehozása a feladata
 */
public class Map {
    private Handler handler;
    private int width, height;
    private int spawnX,spawnY;
    private int[][] tile;
    /**
     * Map konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param handler objektum
     * @param path elérés
     * Itt töltjük be a pályát amikor meghívjuk a loadMap()-et
     */
    public Map(Handler handler, String path){
        this.handler=handler;
        LoadMap(path);
    }
    public void update(){

    }
    /**
     * render
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * kockákat tölt be
     */
    public void render(Graphics g){
        for (int y = 0;y<height;y++){
            for (int x=0;x<width;x++){
                getTile(x,y).render(g,x*Tile.TILE_WIDTH,y*Tile.TILE_HEIGHT);
            }
        }
    }
    /**
     * getTile
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param x kordináta
     * @param y kordináta
     * Megnézi hogy az adott kordinátákon mivan ha van van rajta valami elem akkor azt adja vissza ha nincs akkor sima füvet
     */
    public Tile getTile(int x,int y){

           Tile t = Tile.tiles[tile[x][y]];
        if (t==null){
            return Tile.grassTile;
        }
        return t;
    }
    /**
     * Loadmap
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param path útvonal
     * Ez a függvény tölti be a pályát
     */
    private void LoadMap(String path){
        String file = Util.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Util.parseInt(tokens[0]);
        height = Util.parseInt(tokens[1]);
        spawnX = Util.parseInt(tokens[2]);
        spawnY = Util.parseInt(tokens[3]);

        tile = new int[width][height];
        for (int y = 0;y<height;y++){
            for (int x=0;x<width;x++){
                tile[x][y] = Util.parseInt(tokens[(x+y*width)+4]);
            }
        }
    }
}
