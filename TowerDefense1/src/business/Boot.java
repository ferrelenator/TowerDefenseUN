/*
TO DO:
- Tipos de torres 
- Tipos de enemigos
- Actualizar torres
- Crear Oleadas y manejo de oleadas
- Pausar el tiempo o adelantarlo
- verificar metodo para hacer mover al enemigo esta en Rule moveEnemy()
- verificar metodo el rango de la torre esta en Rule attack()
- Cuadrar los metodos de UI por si el usuario ingresa letras o otras cosas que 
no sean numeros
- Actualizar los diagramas de actividades, de clase, los Mockups 
*/

package business;


import data.*;
import ui.UI;

public class Boot  {
    
    private static Board board;
    private static Player player;
    private static Turn turn;
    private static Rule rule;
    private static boolean exit ;
    
    public static void main(String[] args) {  
        Star();
    }
    
    public static void Star(){
        exit = true;
        while(exit){    
            UI.printTitle();
            int userOpt =UI.readerInt();
            switch(userOpt){
                case 1:
                    startGame();                   
                    break;
                case 2:
                    UI.gameInstruction();
                    break;
                case 3:
                    UI.devNotes();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                   UI.error(0);        
            }
        }
    }

    public static void startGame() {
        boolean exit2=true;
        while(exit2){
        board=new Board();
        player = new Player();
        rule=new Rule(board,player);
        turn=new Turn(20,board,rule,player);
        turn.run();
        UI.printNewGame();
        int user=UI.readerInt();
        switch(user){
                case 1:                  
                   break;
                case 2:
                   exit2=false;
                   break;
                case 3:
                   System.exit(0);
                   break;
                default:
                   UI.error(0);        
            }
        }
        
    }
}
        
    
    
    
 

    





       
    


