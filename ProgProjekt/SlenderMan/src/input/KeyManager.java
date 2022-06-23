package input;

import entities.creatures.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Keymanager class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Ez az osztály felelős a billentyűzet leütésért
 */
public class KeyManager implements KeyListener {
    public boolean[] keys;
    public boolean up,down,left,right;
    public boolean kor=false;


    /**
     * Keymanager konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Megadja a keys nagyságát
     */
    public KeyManager(){
        keys = new boolean[256];
    }
    /**
     * update
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Kimenti hogy melyik gomb melyik irányba menjen
     */
    public void update(){
        up =keys[KeyEvent.VK_W];
        down =keys[KeyEvent.VK_S];
        left =keys[KeyEvent.VK_A];
        right =keys[KeyEvent.VK_D];
    }
    /**
     * keyPressed
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Megnézi hogy van e gomb lenyomva illetve a kor nezese is itt ellenőrződik
     */
    @Override
    public void keyPressed(KeyEvent e) {
            keys[e.getKeyCode()] = true;
            kor=true;


    }
    /**
     * keyReleased
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Megnézi hogy felengedtük e a gombot
     */
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()]=false;

    }
    /**
     * keyTyped
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Lényegében nem csinál most semmit de meg kell hívni ha a KeyListenert akarjuk használni
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }
}
