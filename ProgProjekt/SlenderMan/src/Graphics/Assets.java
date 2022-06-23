package Graphics;

import java.awt.image.BufferedImage;
/**
 * Assets class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Az elemek megjelenítéséért felelős
 */
public class Assets {
    public static BufferedImage jatekos,slenderman,kocka,kisfa,nagyfa,auto,teherauto,szikla,hordo,wall,floor,door,papir;
    //Ez fog mindent betolteni a jatekunkba
    /**
     * init
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Létre hozza az elemeket
     */
    public static void init(){
        jatekos = ImageLoader.loadImage("/PaintSlenderman/karakter.png");
        slenderman = ImageLoader.loadImage("/PaintSlenderman/Slenderman.png");
        kisfa = ImageLoader.loadImage("/PaintSlenderman/kisfa.png");
        kocka = ImageLoader.loadImage("/PaintSlenderman/fu.png");
        auto = ImageLoader.loadImage("/PaintSlenderman/auto.png");
        teherauto = ImageLoader.loadImage("/PaintSlenderman/teherauto.png");
        nagyfa = ImageLoader.loadImage("/PaintSlenderman/fa.png");
        szikla = ImageLoader.loadImage("/PaintSlenderman/ko.png");
        hordo = ImageLoader.loadImage("/PaintSlenderman/hordo.png");
        wall=ImageLoader.loadImage("/PaintSlenderman/fal.png");
        floor=ImageLoader.loadImage("/PaintSlenderman/padlo.png");
        door=ImageLoader.loadImage("/PaintSlenderman/ajto.png");
        papir=ImageLoader.loadImage("/PaintSlenderman/papir.png");
    }
}
