package states;

import Slenderman.Handler;

import java.awt.*;
/**
 * State class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Játék állapotát lehet lekérni állítani
 */
public abstract class State {
    //állapot manager
    private static State currentState = null;

    public static void setState(State state){//ezzel választjuk ki melyik állapotot szeretnénk
        currentState=state;
    }
    public static State getState(){
        return currentState;
    }

    //class
    protected Handler handler;
    /**
     * State
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param handler objektum
     */
    public State(Handler handler){
        this.handler=handler;
    }
    /**
     * update
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Frissít
     */
    public abstract void update();
    /**
     * render
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Renderel
     */
    public abstract void render(Graphics g);

}
