package entities.creatures;
import Graphics.Assets;
import Muveletek.PapirMuvelet;
import Slenderman.Handler;
import entities.Slenderman;

import java.awt.*;


/**
 * Player class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Ez az osztály  a játékossal kapcsolatos dolgokkal foglalkozik
 */

public class Player extends Creature{
    Slenderman slenderman=new Slenderman(this);
    int elozoKorok=0;
    public int korok=0;
    public int papirszam;
    PapirMuvelet helyek= new PapirMuvelet();
    public String[] helyei=helyek.nyolcHely();
    public int jelenX;
    public int jelenY;
    public boolean van=false;
    /**
     * Player konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param handler objektum
     * @param x játékos pozi
     * @param y játékos pozi
     */
    //keymanager elerese miatt
    public Player(Handler handler, int x, int y) {
        super(handler,x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);

    }

    /**
     * Update
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Azért felelős hogy frissítse a mozgást, ha van vagy a papir a kozelben az is itt hivodik meg
     * itt hívódik meg a slender teleportáció és megnézi azt is hogy ránk teleportáltak e
     */
    @Override
    public void update() {
            getInput();
            move();
            papirKozelben();
            if (papirszam>0){
                if (korok>elozoKorok) {
                    slenderman.teleportal();
                    elozoKorok=korok;
                }
                slenderman.elkaptak(getX() / 40, getY() / 40);
            }
    }



    public int getKorok() {
        return korok;
    }

    public void setKorok() {
        this.korok++;
    }

    /**
     * getInput
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Azért felelős hogy a játékos mozogjon attó függően hogy melyik gombot nyomja le és közben a körök számát is növeli ha már van papírunk
     */
    private void getInput(){
        xMove = 0;
        yMove = 0;

        if (handler.getKeyManager().up){
            yMove = -speed;
        }
        if (handler.getKeyManager().down){
            yMove = speed;
        }
        if (handler.getKeyManager().left){
            xMove = -speed;
        }
        if (handler.getKeyManager().right){
            xMove = speed;
        }
        if (handler.getKeyManager().kor){
            if (papirszam>0) {
                setKorok();
                handler.getKeyManager().kor = false;
            }
        }

    }


    public int getJelenX() {
        return jelenX;
    }

    public void setJelenX(int jelenX) {
        this.jelenX = jelenX;
    }

    public int getJelenY() {
        return jelenY;
    }

    public void setJelenY(int jelenY) {
        this.jelenY = jelenY;
    }

    public int getPapirszam() {
        return papirszam;
    }

    public void setPapirszam() {
        this.papirszam++;
    }
    /**
     * papirKozelben
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Azért felelős hogy megnézze hogy van e a közelben papír és ha van akkor növelje a papír számokat
     */
    public Boolean papirKozelben(){

        for (int i=0;i<helyei.length-1;i+=2) {
            if ((Integer.parseInt(helyei[i]) == getX() && Integer.parseInt(helyei[i+1]) == getY()) ||
                    (Integer.parseInt(helyei[i]) - 40 == getX() && Integer.parseInt(helyei[i+1])== getY()) ||
                    (Integer.parseInt(helyei[i]) + 40 == getX() && Integer.parseInt(helyei[i+1])== getY()) ||
                    (Integer.parseInt(helyei[i+1]) - 40 == getY() && Integer.parseInt(helyei[i])== getX()) ||
                    (Integer.parseInt(helyei[i+1]) + 40 == getY() && Integer.parseInt(helyei[i])== getX()) ){

                            setPapirszam();
                            System.out.println("Papirok szama: " + getPapirszam());
                            setJelenX(Integer.parseInt(helyei[i]));
                            setJelenY(Integer.parseInt(helyei[i+1]));
                            van=true;

                            helyei[i]="11";
                            helyei[i+1]="11";
                            if (getPapirszam()==8){
                                System.out.println("Nyertél!!");
                                System.exit(0);
                            }
                return true;
            }
        }
        van=false;
    return false;
    }
    /**
     * render
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * A játékost jeleníti meg illetve a papírt egy kis időre ha épp mellette vagyunk mivel egyből fel is veszi slendermen is itt lesz renderelve mivel játékos
     * pozival kell összehasonlítani a math es része felelős azért hogy 3 sugarú körös távban legyen
     */
    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.jatekos,(int) x,(int) y, width,height,null);
        if (van){
            g.drawImage(Assets.papir,getJelenX(),getJelenY(),null);
        }
        if (Math.sqrt((slenderman.getSxpozi()-getX()/40)*(slenderman.getSxpozi()-getX()/40)+(slenderman.getSypozi()-getY()/40)*(slenderman.getSypozi()-getY()/40))<3){
            slenderman.render(g,slenderman.getSxpozi(),slenderman.getSypozi());
        }
    }
}
