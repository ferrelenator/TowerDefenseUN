package TD.ui;

import java.util.Scanner;
import TD.data.Board;

public class UI {
    
    
    private static Scanner readerMenu = new Scanner(System.in);

    public static void printMenu() {

        System.out.println("[---Tower Defense Indev:5---]");
        System.out.println("|     Menu principal:       |");
        System.out.println("|     1.Nueva Partida.      |");
        System.out.println("|        2.Resumen.         |");
        System.out.println("|     3.Indev 5 Notes.      |");
        System.out.println("|     4.Salir del juego.    |");
        System.out.println("-----------------------------\n");
        System.out.println("Seleccione una Opcion: ");
    }
    
    public static void gameInstruction(){
        System.out.println("                     Bienvenido:\n");
        System.out.println("       Tower defense es un juego de estrategia");
        System.out.println("      utilizando torres ubicadas con coordenadas");
        System.out.println("    debe derrotar a las oleadas de enemigos antes");
        System.out.println("de que lleguen al final del camino, puede recolectar");
        System.out.println("  dinero con cada baja, y asi mejorar sus defensas");
        System.out.println("      El jugador gana si completa las oleadas");
        System.out.println("\n\n");
    }
    public static void devNotes(){
        System.out.println("            Indev5: 5ta version Tower Defense");
        System.out.println("       [-]Retirado temporalmente el uso de Timer");
        System.out.println("       [>]Modificacion Completa De la Interfaz");
        System.out.println("       [>]Correccion de metodos para las clases");
        System.out.println("       [+]Adicion de Clases funcionales");
        System.out.println("\n\n");
    }
    
    public static int menuDevelop(){
       return readerMenu.nextInt();
    }
    
    public static void towers(){
        System.out.println("Select the square to locate the towers and press the enter key: ");
        System.out.println("Select row and col for the 1st tower (it has to be on terrain (delimited with the X symbol))");

}
    
     public static int time(){
       int i;
       i = readerMenu.nextInt();
       
       return 1;
    }
    
    public static void errorInt(){
        System.out.println("\n\nSolo números entre 1 y 4");
    }
    
    public static void printFiles(){
        System.out.print("       [0|1|2|3|4|5|6|7|8|9]");
    }

    
    public static void printBoard(Board board) {
        System.out.println(board);
    }


}
