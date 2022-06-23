package Slenderman;

/**
 * Launcher class
 * @author Nagyfalusi Dávid Márton
 * @version 1.0
 * Játék elindítása
 */
public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("Slenderman",600,600);
        game.start();
    }
}
