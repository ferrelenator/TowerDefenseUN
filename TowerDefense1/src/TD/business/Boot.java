/*
TO DO:

- Menu principal : un menu principal que permita Iniciar un nuevo juego, salir del juego 
- Crear el "tiempo"
- Pausar el tiempo o adelantarlo
- Crear Oleadas y manejo de oleadas
- Clase jugador que se encargue de posicionar torres
*/

package TD.business;

import TD.data.Wave;
import TD.data.*;
import TD.ui.UI;

public class Boot  {
    
    private static Board board;
    private static Tower tower;
    private static Enemy enemy;
    private static Wave wave;
    
    
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

    private static void startGame() {
        Map.newMap();
        enemy=new Enemy(2,0,1);
        wave= new Wave(1,enemy,board);
        wave.update();
        UI.printBoard(board); 
    
    
    }} 
   // Enemy enemy = new Enemy (4,0,1);
   // enemy.drawn(board);
   //  UI.printBoard(board);
   // tower.drawn(board);
   // enemy.drawn(board);
    
    //timer.update(board,enemy,tower);
    
     //   for (int a = (int)enemy.getY() ; a < 10; a++){
      //      enemy.update(enemy.getX(),a);
      //      enemy.drawn(board);
            
      //      UI.printBoard(board);
      //  }
        
    
    
    
 

    





       
    


