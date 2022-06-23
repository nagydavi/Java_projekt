package tiles;

import Graphics.Assets;

/**
 * Rock class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * A Tile class gyereke konkrét elem
 */
public class Rock extends Tile{

    public Rock(int id) {
        super(Assets.szikla, id);
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
