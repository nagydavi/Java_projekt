package Slenderman;

import Graphics.Assets;

import Display.Display;
import entities.creatures.Player;
import input.KeyManager;
import states.GameState;
import states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
/**
 * Game class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Itt fut maga a játék
 */
// A runnable a thread miatt kell
public class Game implements Runnable{

    private Display display;
    public int width,height;
    public String title;

    private boolean running = false;
    private Thread thread;
    // a bufferS megmondja a gépnek hogy rajzoljon a kijelzőre és ezekhez buffereket használ
    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    private State menuState;

    //Input
    private KeyManager keyManager;

    //Handler
    private Handler handler;

    //Jatekos
    private Player jatekos;
    /**
     * Game konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param title cím
     * @param width szélesség
     * @param height magasság
     */
    public Game(String title, int width , int height){
        this.width=width;
        this.height=height;
        this.title=title;
        keyManager= new KeyManager();
    }
    /**
     * init
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * A grafikus dolgokat tölti be a játéknak
     */
    //a grafikus dolgokat fogja betölteni a játéknak
    private void init(){
        display = new Display(title,width,height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler = new Handler(this);
        //állapot
        gameState = new GameState(handler);
        State.setState(gameState);
    }
    /**
     * update
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * frissiti a alapotot
     */
    private void update(){
        keyManager.update();

        if (State.getState()!=null){
            State.getState().update();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    /**
     * render
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * pálya megjelenítés
     */
    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        //erre azért van szükség mert ha elsőre használjuk nem tudja mennyi buffer kell ezért mi megmondjuk neki ha még nem volt
        if (bs==null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        //így rajzolhatunk a kijelzőre
        g = bs.getDrawGraphics();
        //Képernyő tisztítása
        g.clearRect(0,0,width,height);
        //Rajzolas kezdes
        if (State.getState()!=null){
            State.getState().render(g);
        }
        //rajzolas vege
        bs.show();
        g.dispose();

    }
    /**
     * run
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * játék futásáért felelős
     */
    //runnablehez elengedhetetlen mert másképp errort írna ki az implements miatt
    public void run(){
        init();
        long lastTime = System.nanoTime();
        double amountOfTicks = 10.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int ticks = 0;

        long renderLastTime=System.nanoTime();
        double amtOfRenders = 10.0;//MAX FPS
        double renderNs=1000000000/amtOfRenders;
        double renderDelta = 0;

        //game loop
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                update();
                ticks++;
                delta--;
            }

            now = System.nanoTime();
            renderDelta += (now - renderLastTime) / renderNs;
            renderLastTime = now;
            while(running && renderDelta >= 1){
                render();
                frames++;
                renderDelta--;
            }

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                frames = 0;
                ticks = 0;
            }

        }
        stop();//ha elsőre nem ált volna le
    }
    //hogy a jatekos classban is elerhető legyen
    public KeyManager getKeyManager(){
        return keyManager;
    }
    /**
     * start
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * elkezdik illetve befejzik a threadet a synchronized azért kell mert direktbe dolgozunk a threadel és nem akarjunk hogy valami rosszul menjen végbe
     */
    //elkezdik illetve befejzik a threadet a synchronized azért kell mert direktbe dolgozunk a threadel és nem akarjunk hogy valami rosszul menjen végbe
    public synchronized void start(){
        if (running) return;//azért kell mert ha már fut ne indítsuk újra és ne okozzunk hibát
        running = true;
        thread = new Thread(this);// a this a classra mutat hogy egy threaden futtassuk
        thread.start();// a run metódust hívja

    }
    /**
     * stop
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Thread miatt kell
     */
    public synchronized void stop(){
        if(!running) return;//azért kell hogy ha már nem fut akkor ne zárjuk be újra és ne okozzunk hibát
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }
}
