package tiles;

import Graphics.Assets;

import java.awt.*;

/**
 * Papir class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * A Tile class gyereke konkrét elem
 */
public class Papir extends Tile{



    public Papir(int id) {
        super(Assets.papir, id);
    }
    /**
     * render
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Papír megjelenítéséért felelős
     */
    @Override
    public void render(Graphics g,int x,int y) {
        g.drawImage(Assets.papir,(int) x,(int) y, 40,40,null);
    }

}
