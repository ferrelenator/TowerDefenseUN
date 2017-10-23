/*
TO DO:

- Menu principal : un menu principal que permita Iniciar un nuevo juego, salir del juego 
- Crear el "tiempo"
- Pausar el tiempo o adelantarlo
- Crear Oleadas y manejo de oleadas
- Clase jugador que se encargue de posicionar torres
*/

package TD.business;


import TD.data.*;
import TD.ui.UI;

public class Boot  {
    
    private static Board board;
    private static Array array;
    private static Artist art;
    private static Turn turn;
    public static void main(String[] args) {  
        Star();
    }
    
    public static void Star(){
        
       boolean exitOpt = false;
         
       while(!exitOpt){
           
        UI.printMenu();
        
        int userOpt =UI.menuDevelop();
            
           switch(userOpt){
               case 1:
                   exitOpt=true;
                   startGame();                   
                   break;
               case 2:
                   UI.gameInstruction();
                   break;
                case 3:
                   UI.devNotes();
                   break;
                case 4:
                   exitOpt=true;
                   break;
                default:
                   UI.errorInt();
                   
           }
        }
    }

    public static void startGame() {

    board=new Board();
    array= new Array();
   array.newTower();  
    art=new Artist();
    art.paint(board,array);
    System.out.println(art.getPrintBoard());
    turn=new Turn(15,board,array,art);
    turn.run();
    }
    
 
        
}
    //timer.update(board,enemy,tower);
    
     //   for (int a = (int)enemy.getY() ; a < 10; a++){
      //      enemy.update(enemy.getX(),a);
      //      enemy.drawn(board);
            
      //      UI.printBoard(board);
      //  }
        
    
    
    
 

    





       
    


