package ui;

import java.util.Scanner;
import data.*;

public class UI {
    
    
    private static Scanner readerMenu = new Scanner(System.in);

    public static void printTitle() {
        System.out.println("[---   Tower Defense     ---]");
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
    
    public static void printMenu(){
        
        System.out.println("[------ Menu del juego -----]");
        System.out.println("|    Opciones del juego :   |");
        System.out.println("|  1.Adelantar un segundo.  |");
        System.out.println("|  2.Construir una torre.   |");
        System.out.println("|  3.Remover una torre.     |");
        System.out.println("|  4.Información Jugador.   |");
        System.out.println("|  5.Información Torres.    |");
        System.out.println("|  6.Información Enemigos.  |");
        System.out.println("|  7.Menu de Opciones.      |");        
        System.out.println("|  8.Salir del juego.       |");
        System.out.println("|  9.No detener el tiempo.  |");
        System.out.println("-----------------------------\n");
        System.out.println("Seleccione una Opcion: ");
    }
    
  /*  public static void printNewGame(){
        System.out.println("[---  Menu de Opciones   ---]");
        System.out.println("|     1.Nueva Partida.      |");
        System.out.println("|     3.Indev 5 Notes.      |");
        System.out.println("|     4.Salir del juego.    |");
        System.out.println("-----------------------------\n");
        System.out.println("Seleccione una Opcion: ");
    } */
    
    public static void printNewGame(){
        System.out.println("[---  Menu de Opciones   ---]");
        System.out.println("|     1.Nueva Partida.      |");
        System.out.println("|     2.Menu principal.     |");
        System.out.println("|     3.Salir del juego.    |");
        System.out.println("-----------------------------\n");
        System.out.println("Seleccione una Opcion: ");
    }
    
    public static int readerInt(){
       return readerMenu.nextInt();
    }
    
    public static void time(int i){
        System.out.println("Ha  pasado "+i+" Segundos");
    }
    
    public static int[] placeTower(){
        int[] i = new int[2];
        System.out.println("Seleccione las coordeanadas para la nueva torre ");
        System.out.println("Seleccione la fila : ");
        i[0]=readerMenu.nextInt();
        System.out.println("Seleccione la Columna : ");
        i[1]=readerMenu.nextInt();
        return i;
    }
    
    public static void moneyEnemy(Enemy enemy){
        System.out.println("Enemigo "+enemy.getValue()+" Derrotado, ganas " 
                 +enemy.getMoney()+" de oro. \n");
    }
    
    public static void moneyTower(Tower tower){
        System.out.println("Torre "+tower.getValue()+" Destruida , ganas " 
                 + tower.getSell() +" de oro. \n");
    }
    
    public static int selectTower(Board board){
        System.out.println("Seleccione el indice de la torre");
            board.getTowerList().forEach((t) -> {
                System.out.println("Indice "+board.getTowerList().indexOf(t)+" de la torre "+t.getValue()+" ( "+t.getRow()
                     +","+t.getCol()+" ) : \n");
        });
          
        return readerMenu.nextInt();
    }
    
    public static void moneyTower(Tower tower, int i){
        System.out.println(tower.getValue()+" Colocada  pierdes" 
                 +tower.getPrice()+" de oro. \n");
    }
    
    public static void infoPlayer(Player player){
        System.out.println("jugador : \n"+ player.getMoney()+" de oro. \n "
                +player.getLife()+ " de vida. \n");
    }
    
    public static void infoEnemy(Board board){
         board.getEnemyList().forEach((e) -> {
             System.out.println("El enemigo "+e.getValue()+" ( "+e.getRow()
                     +","+e.getCol()+" ) : \n"
                     +e.getHealth()+" de vida. \n"
                     +e.getSpeed()+" de velocidad. \n");
        });
    }
   
    public static void infoTower(Board board){
        board.getTowerList().forEach((t) -> {
             System.out.println("La torre "+t.getValue()+" ( "+t.getRow()
                     +","+t.getCol()+" ) : \n"
                     +t.getDamage()+" de daño. \n"
                     +t.getRange()+ " de rango. \n"
             );
        });
    }
       
    public static void error(int i){
        switch(i){
            case 0:
                System.out.println("\n Solo estan las opciones 1 , 2 , 3 , 4\n");
                break;
            case 1:
                System.out.println("\n La torre no se puede colocar hay\n");
                break;
            case 2:
                System.out.println("\n No hay suficiente dinero para comprar torres \n");
                break;    
        }
    }
    
    public static void win(int i){
        switch(i){
            case 0:
                System.out.println("\n ********** Ganaste ************* \n");
                break;
            case 1:
                System.out.println("\n ********** Perdiste ************* \n");
                break;   
        }
    }
    
    public static void printBoard(Board board) {
        String map=paint(board);
        System.out.println(map);
    }
    
    public static String paint(Board board) {
        String printBoard= "\n"; 
        char[][] value= new char[ board.getBoard().length][ board.getBoard().length];   
         
        for (int row = 0; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard().length; col++) {
                value[row][col]=board.getBoard()[row][col].getValue();
            }
        }
        board.getTowerList().forEach((t) -> {
            value[t.getRow()][t.getCol()]= t.getValue();
        });
        board.getEnemyList().forEach((e) -> {
            value[e.getRow()][e.getCol()]=e.getValue();
        });    
        for (int row = 0; row < board.getBoard().length; row++) {
            printBoard=printBoard.concat("\t").concat("[").concat(String.valueOf(row)).concat("] ");
                for (int col = 0; col < board.getBoard().length; col++) {
                    printBoard =printBoard.concat(String.valueOf(value[row][col])).concat(" ");
                }
            printBoard = printBoard.concat("\n");
        }
        printBoard="\t   [0|1|2|3|4|5|6|7|8|9]".concat(printBoard);
        return printBoard;    
    }
}
