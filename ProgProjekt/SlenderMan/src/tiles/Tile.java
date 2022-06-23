package tiles;

import java.awt.*;
import java.awt.image.BufferedImage;
/**
 * Tile class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Kockák vannak benne és azok megjelenítése
 */
public class Tile {

    //Static stuff here
    public static Tile[] tiles = new Tile[256];
    public static Tile grassTile= new Grass(0);
    public static Tile smallTree= new SmallTree(1);
    public static Tile bigTree= new BigTree(2);
    public static Tile rock= new Rock(3);
    public static Tile barrel= new Barrel(4);
    public static Tile car= new Car(5);
    public static Tile bigCar= new BigCar(7);
    public static Tile floor = new Floor(8);
    public static Tile door = new Door(9);
    public static Tile wall= new Wall(6);
    public static Tile papir = new Papir(11);
    //CLAss
    public static final int TILE_WIDTH = 40,TILE_HEIGHT=40;
    protected BufferedImage texture;
    protected final int id;
    /**
     * Tile konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param texture kocka kinézet
     * @param id kocka id
     */
    public Tile(BufferedImage texture, int id){
        this.texture=texture;
        this.id=id;

        tiles[id] = this;
    }
    public void update(){

    }
    /**
     * render
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Megjeleníti a kivánt kockat
     */
    public void render(Graphics g, int x,int y){
        g.drawImage(texture,x,y,TILE_WIDTH,TILE_HEIGHT,null);
    }
    /**
     * isSolid
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Áthatolható-e vagy sem a kocka
     */
    public boolean isSolid(){
        return false;
    }

    public int getId(){
        return id;
    }

}
