package TD.ui;

import java.util.Scanner;
import TD.data.Board;
import TD.data.Map;

public class UI {
    
    
    private static Scanner readerMenu = new Scanner(System.in);

    public static void printMenu() {

        System.out.println("[---Tower Defense Indev:5---]");
        System.out.println("|     Menu principal:       |");
        System.out.println("|     1.Nueva Partida.      |");
        System.out.println("|     2.Instrucciones.      |");
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
    }
    public static void devNotes(){
        System.out.println("            Indev5: 5ta version Tower Defense");
        System.out.println("       [-]Retirado temporalmente el uso de Threads");
        System.out.println("       [>]Modificacion Completa De la Interfaz");
        System.out.println("       [>]Correccion de metodos para las clases");
        System.out.println("       [+]Adicion de Clases funcionales");
        
    }
    
    public static void MenuDevelop(){
       boolean exitOpt = false;
       int userOpt;
       
       while(!exitOpt){
           printMenu();
           userOpt = readerMenu.nextInt();
            
           switch(userOpt){
               case 1:
                   Map.startGame();
                   System.out.println("\n\n");
                   break;
               case 2:
                   gameInstruction();
                   System.out.println("\n\n");
                   break;
                case 3:
                   devNotes();
                   System.out.println("\n\n");
                   break;
                case 4:
                   System.out.println("Saliendo del juego\n\n");
                   exitOpt=true;
                   break;
                default:
                   System.out.println("\n\nSolo números entre 1 y 4");
                   
           }
        }
    }
    
    public static void printFiles(){
        System.out.print("       [0|1|2|3|4|5|6|7|8|9]");
    }

    
    public static void printBoard(Board board) {
        System.out.println(board);
    }


}
