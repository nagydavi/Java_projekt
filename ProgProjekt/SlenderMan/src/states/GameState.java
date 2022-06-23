package states;
import Graphics.Assets;
import Slenderman.Game;
import Slenderman.Handler;
import entities.creatures.Player;
import map.Map;
import tiles.Papir;
import tiles.Tile;

import java.awt.*;
/**
 * GameState class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Játék állapotért felelős mapet játékost stb hozzuk létre benne
 */
//jatek megjelenítés
public class GameState extends State{

    private Player jatekos;
    private Map map;
    Papir papir;
    /**
     * GameState konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param handler objektum
     */
    public GameState(Handler handler){
        super(handler);
        map = new Map(handler,"Jatekelemek/map/map1");
        handler.setMap(map);
        jatekos=new Player(handler, 560,0);

    }

    /**
     * Game class
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Itt fut maga a játék
     */
    @Override
    public void update() {
        map.update();
        jatekos.update();
    }
    /**
     * render
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Itt fut maga a játék
     */
    @Override
    public void render(Graphics g) {
        map.render(g);
        jatekos.render(g);
    }
}
