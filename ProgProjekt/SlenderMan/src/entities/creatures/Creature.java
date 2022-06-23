package entities.creatures;

import Slenderman.Handler;
import entities.Entity;
/**
 * Creature class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Ebben az osztályban nézzük meg, hogy a karakterünk bír e arra mozogni ahova menni akar
 */

public abstract class Creature extends Entity {

    public static final int DEFAULT_SPEED = 40;
    public static final int DEFAULT_CREATURE_WIDTH=40;
    public static final int DEFAULT_CREATURE_HEIGHT=40;

    protected int speed;
    protected int xMove,yMove;


    /**
     * move
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Az x és az y írányú mozgást hívja meg
     */
    public void move(){
        moveX();
        moveY();

    }
    /**
     * moveX
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Az x írnyú mozgás ellenőrzéséért és végrehajtásáért felelős
     */
    public void moveX(){
        if( x+xMove>=0 && x+xMove<600){
            if (((yMove+y)/DEFAULT_CREATURE_HEIGHT)<15 && ((yMove+y)/DEFAULT_CREATURE_HEIGHT)>(-1) && ((xMove+x)/DEFAULT_CREATURE_WIDTH)<15 && ((xMove+x)/DEFAULT_CREATURE_WIDTH)>(-1) ){
                if (!collisionWithTile((x+xMove)/DEFAULT_CREATURE_WIDTH,(yMove+y)/DEFAULT_CREATURE_HEIGHT)){
                    x+=xMove;
                }
            }
        }

    }
    /**
     * moveY
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Az y írnyú mozgás ellenőrzéséért és végrehajtásáért felelős
     */
    public void moveY(){
        if(y+yMove>=0 && y+yMove<600){
            if (((yMove+y)/DEFAULT_CREATURE_HEIGHT)<15 && ((yMove+y)/DEFAULT_CREATURE_HEIGHT)>(-1) && ((xMove+x)/DEFAULT_CREATURE_WIDTH)<15 && ((xMove+x)/DEFAULT_CREATURE_WIDTH)>(-1) ){
                if (!collisionWithTile((x+xMove)/DEFAULT_CREATURE_WIDTH,(yMove+y)/DEFAULT_CREATURE_HEIGHT)){
                    y+=yMove;
                }
            }

        }
    }
    /**
     * collisionWith
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param x kordináta
     * @param y kordináta
     * Megnézi hogy a paraméterben kapott kordinátákban a kockán átlehet e menni
     */
    protected boolean collisionWithTile(int x, int y){
            return handler.getMap().getTile(x, y).isSolid();

    }
    //Getter setter
    public float getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(int xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(int yMove) {
        this.yMove = yMove;
    }
    /**
     * Creature konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param handler objektum
     * @param x kordináta
     * @param y kordináta
     * @param width szélesség
     * @param height magasság
     */
    public Creature(Handler handler,int x, int y, int width, int height) {
        super(handler,x, y,width,height);
        this.speed = DEFAULT_SPEED;
        this.xMove =0;
        this.yMove=0;
    }


}
