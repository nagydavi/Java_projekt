package Muveletek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * PapirMuvelet class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Ez az osztály felelős a papir elhelyezésért
 */
public class PapirMuvelet {
    public Map<Integer,String> elhelyezKedes = new HashMap<>();

    /**
     * getElhelyezkedes
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Itt lesznek fix helyek amik közül válogathatunk random 8 at
     */
    public Map<Integer, String> getElhelyezKedes() {
        elhelyezKedes.put(1,"80,80,");
        elhelyezKedes.put(2,"120,120,");
        elhelyezKedes.put(3,"240,40,");
        elhelyezKedes.put(4,"0,280,");
        elhelyezKedes.put(5,"0,560,");
        elhelyezKedes.put(6,"120,520,");
        elhelyezKedes.put(7,"280,280,");
        elhelyezKedes.put(8,"560,400,");
        elhelyezKedes.put(9,"480,120,");
        elhelyezKedes.put(10,"480,0,");
        elhelyezKedes.put(11,"360,120,");
        elhelyezKedes.put(12,"200,560,");
        elhelyezKedes.put(13,"240,440,");
        elhelyezKedes.put(14,"440,560,");
        return elhelyezKedes;
    }
    /**
     * papirHelyek
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * Itt választódik ki random 8 szám ami majd megmondja mely helyek kellenek
     */
    public ArrayList<Integer> papirHelyek(){
        int db=0;
        ArrayList<Integer> szamok =new ArrayList<Integer>();
        Random szam = new Random();
        int nez;
        boolean egyezes=false;
        while (db!=8){
            nez=szam.nextInt(14)+1;
            for (int num : szamok){
                if (num==nez){
                    egyezes=true;
                    break;
                }
            }
            if (!egyezes){
                szamok.add(nez);
                db++;
            }
            egyezes=false;
        }
        return szamok;
    }
    /**
     * nyolcHely
     * @author Nagyfalusi Dávid Márton
     * @version 1.0
     * A konkrét kordináták ebben a string tömben lesznek letárolva
     */
    public String[] nyolcHely(){
        ArrayList<Integer> szamok= papirHelyek();
        String[] helyek;
        String szovegszamok="";
        for (int i=0;i<szamok.size();i++){
            szovegszamok+=getElhelyezKedes().get(szamok.get(i));
        }
        helyek=szovegszamok.split(",");
        return helyek;
    }
}
