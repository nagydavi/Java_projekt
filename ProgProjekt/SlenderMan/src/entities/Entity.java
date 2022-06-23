package entities;

import Slenderman.Handler;

import java.awt.*;
/**
 * Entity class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Ez az osztály a creature és a player szülője ebből indul ki minden dolga a játékosnak
 */
public abstract class Entity {
    protected Handler handler;
    protected int x,y;
    protected int width,height;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    /**
     * Entity konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param handler objektum
     * @param x játékos pozi
     * @param y játékos pozi
     * @param width játékos szélesség
     * @param height játékos magasság
     */

    public Entity(Handler handler, int x, int y, int width, int height){
        this.handler=handler;
        this.x = x;
        this.y = y;
        this.width=width;
        this.height=height;


    }
    public abstract void update();
    public abstract void render(Graphics g);

}
