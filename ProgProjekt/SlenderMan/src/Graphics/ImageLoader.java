package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * ImageLoader class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Ez az osztály a képek betöltéséért felelős
 */
public class ImageLoader {
    //itt tárolja a képeket a java
    /**
     * Entity class
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param path elérés
     * Betölti a paraméterben kapott útvonalú képet
     */
    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
