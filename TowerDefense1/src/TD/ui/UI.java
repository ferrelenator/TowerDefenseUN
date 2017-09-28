
package TD.ui;

import java.util.Scanner;
import TD.data.Board;


public class UI {
    
    
      private static String extraTiralineas = "                  [-°=°~°°~°°~°°~°°~°|V|°~°°~°°~°°~°°~°°~°]";
    private static Scanner reader = new Scanner(System.in);

    public static void printWelcome() {

        System.out.println(extraTiralineas);
        System.out.println("[<°>=<°>=<°>=<°>=<°>=<°>=<°>=<°>]TowerDefense VER 0.1[<°>=<°>=<°>=<°>=<°>=<°>=<°>]");
        System.out.println(extraTiralineas);

        System.out.println();


        System.out.println();
        System.out.println(extraTiralineas);

    }

    public static void printError() {
        System.out.println("\n\t Error en el juego, por favor reintentar.");
    }

    public static void printBoard(Board board) {
        System.out.println(board);
    }


}
