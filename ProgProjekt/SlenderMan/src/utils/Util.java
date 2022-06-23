package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//segit dolgokat vegrehajtani
/**
 * Util class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Segít dolgokat végrehajtani
 */
public class Util {
    /**
     * loadFileAsString
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Betölti a fájlt stringként map betöltésnél használatos
     */
    public static String loadFileAsString(String path){
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine())!=null){
                builder.append(line + "\n");
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return builder.toString();
    }
    /**
     * parseInt
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * @param number string szám
     * A paraméterben kapott stringet alakítja számmá
     */
    public static int parseInt(String number){
        try {
            return Integer.parseInt(number);
        }catch (NumberFormatException e){
            e.printStackTrace();
            return 0;
        }

    }
}
