package Slenderman;

import input.KeyManager;
import map.Map;

/**
 * Handler class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * mindent elérhetünk általa
 */
public class Handler {
    private Game game;
    private Map map;

    public Handler(Game game) {
        this.game=game;
    }
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }

    public int getWidth(){
        return game.getWidth();
    }
    public int getHeight(){
        return game.getHeight();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

}
