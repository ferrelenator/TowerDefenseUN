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
        UI.MenuDevelop();
    }

}
   
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
        
    
    
    
 

    





       
    


