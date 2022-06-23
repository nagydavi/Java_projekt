package tiles;

import Graphics.Assets;
/**
 * Floor class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * A Tile class gyereke konkrét elem
 */

public class Floor extends Tile{
    public Floor(int id) {
        super(Assets.floor, id);
    }
}
