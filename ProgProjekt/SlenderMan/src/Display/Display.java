package Display;

import javax.swing.*;
import java.awt.*;
/**
 * Display class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Ez az osztály a megjelenítésért felelős
 */
public class Display {
    private JFrame frame;
    //segít abban hogy megjelenítsünk valamit az ablakunkban
    private Canvas canvas;
    private String title;
    // pixelek
    private int width, height;
    /**
     * Display konstruktor
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param title Ablak címe
     * @param width Ablak szélessége
     * @param height Ablak magassága
     */
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDispaly();
    }
    /**
     * creaateDisplay
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Ablakkal kapcsolatos dolgok például hogy bezáródjon stb a kommentek jobban is részletezik
     */
    private void createDispaly(){
        frame = new JFrame(title);
        //ablak nagysága
        frame.setSize(width, height);
        //azért kell hogy ne csak az ablak záródjon be hanem a program is
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        //Ezzel biztosítjuk hogy akkora maradjon amekkorát mi akarunk
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        //hogy működjön az irányítás
        canvas.setFocusable(false);

        frame.add(canvas);
        // hogy biztosan lássuk az egész canvas-et(Vásznat)
        frame.pack();

    }
    // hogy a renderben bírjuk használni
    public Canvas getCanvas(){
        return canvas;
    }
    public JFrame getFrame(){
        return frame;
    }
}
