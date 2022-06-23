package tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;
/**
 * Wall class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * A Tile class gyereke konkrét elem
 */
public class Wall extends Tile{
    public Wall(int id) {
        super(Assets.wall, id);
    }
    /**
     * isSolid
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * A keménységet true-ra állítja
     */
    @Override
    public boolean isSolid(){
        return true;
    }
}
