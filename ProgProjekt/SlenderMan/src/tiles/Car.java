package tiles;

import Graphics.Assets;

/**
 * Car class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * A Tile class gyereke konkrét elem
 */

public class Car extends Tile{
    public Car(int id) {
        super(Assets.auto, id);
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
