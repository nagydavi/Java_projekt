package tiles;

import Graphics.Assets;

/**
 * BigCar class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * A Tile class gyereke konkrét elem
 */


public class BigCar extends Tile{
    public BigCar(int id) {
        super(Assets.teherauto, id);
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
