package entities;

import entities.creatures.Player;

import java.awt.*;
import java.util.Random;
import Graphics.Assets;

/**
 * Slenderman Class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Slenderman adatai mozgása
 */
public class Slenderman {
    public int Sxpozi;
    public int Sypozi;
    Random pozi= new Random();
    Player jatekos;
    public int kozottTav=0;
    public int esely;
    /**
     * Slenderman konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param player objektum
     */
    public Slenderman(Player player){
        this.jatekos=player;
        this.Sxpozi=0;
        this.Sypozi=0;
    }
    public int getSxpozi() {
        return Sxpozi;
    }
    public int getSypozi() {
        return Sypozi;
    }
    /**
     * elkaptak
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * megnézi hogy elkaptak e rajtad áll e slenderman
     */
    public void elkaptak(int x,int y){
        if (x==getSxpozi()&& y==getSypozi()) {
            System.out.println("Elkaptak!!");
            System.exit(0);
        }
    }
    /**
     * teleportal
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * igy fog teleportalgatni slenderman itt valósul meg slenderman mozgása
     */
    public void teleportal(){
        if (jatekos.getKorok()%5==0){
            this.Sxpozi=pozi.nextInt(15);
            this.Sypozi=pozi.nextInt(15);
        }else{
           if (jatekos.getPapirszam()<2){
                normalSlenderPozi(5,true);
           }
            if (jatekos.getPapirszam()>=2 && jatekos.getPapirszam()<4){
                normalSlenderPozi(5,false);
            }
            if (jatekos.getPapirszam()>=4 && jatekos.getPapirszam()<6){
                normalSlenderPozi(4,false);
            }
            if (jatekos.getPapirszam()>=6){
                normalSlenderPozi(3,false);
            }
        }
        if (tavolsagAjatekostol(Sxpozi,Sypozi)==1){
            kozottTav++;
        }else{
            kozottTav=0;
        }
        if (kozottTav==3){
            if (jatekos.getPapirszam()>=2 && jatekos.getPapirszam()<4){
               esely=pozi.nextInt(3);
               if (esely==1){
                   System.out.println("Elkaptak!!");
                   System.exit(0);
               }
            }
            if (jatekos.getPapirszam()>=4 && jatekos.getPapirszam()<6){
                esely=pozi.nextInt(4);
                if (esely==1 || esely==2){
                    System.out.println("Elkaptak!!");
                    System.exit(0);
                }

            }
            if (jatekos.getPapirszam()>=6){
                esely=pozi.nextInt(3);
                if (esely==1 || esely==2){
                    System.out.println("Elkaptak!!");
                    System.exit(0);
                }
            }
            kozottTav=0;
        }

    }
    /**
     * tavolsagAjatekostol
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Manhatten távolságot számol
     */
    public int tavolsagAjatekostol(int x, int y){
        return Math.abs(x-jatekos.getX())+Math.abs(y-jatekos.getY());
    }
    /**
     * normalSlenderPozi
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Legenerálja a normal pozit ahova ugorhat a feltételek szerint
     */
    public void normalSlenderPozi(int manhat, boolean legalabb) { // true ha legalabb akkorat keres false ha legfeljebb
        boolean megfelel = false;
        while (!megfelel) {
            Sxpozi = pozi.nextInt(15);
            Sypozi = pozi.nextInt(15);
                if (tavolsagAjatekostol(Sxpozi, Sypozi) >= manhat) {
                    megfelel = true;
                }


                else if (tavolsagAjatekostol(Sxpozi, Sypozi) <= manhat){
                    megfelel = true;
                    System.out.println("krumpli");

            }
        }
    }
    /**
     * render
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param g Graphics
     * @param x kordináta
     * @param y kordináta
     * Megjeleníti slendermant
     */
    public void render(Graphics g, int x, int y) {
        g.drawImage(Assets.slenderman, x*40, y*40, 40,40,null);
    }
}
