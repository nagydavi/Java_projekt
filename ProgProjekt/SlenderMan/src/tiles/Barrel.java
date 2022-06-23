package tiles;

import Graphics.Assets;

/**
 * Barrel class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * A Tile class gyereke konkrét elem
 */

public class Barrel extends Tile{
    public Barrel(int id) {
        super(Assets.hordo, id);
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
