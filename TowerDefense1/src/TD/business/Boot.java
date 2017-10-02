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
    private static Tower tower;
    private static Enemy enemy;
    private static Timer timer;
    
    
    public static void main(String[] args) {
        
        Timer timer = new Timer(5);
        Thread timerThread = new Thread(timer);

        timerThread.start();

        
        startGame(timer, timerThread);
        
    }

    private static void startGame(Timer timer, Thread timerThread) {
        
        int[][] map ={
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,1,0,0,0,0,0},
            {1,1,1,1,1,0,0,0,0,0},
            {1,1,1,1,1,0,0,0,0,0},
            {0,0,1,1,1,1,1,1,1,1},
            {0,0,1,1,1,1,1,1,1,1},
            {0,0,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            
        };
    
    
    board = new Board(map);
    tower = new Tower(1,1);
    enemy = new Enemy(2,1,1);
    
    UI.printWelcome();
   // tower.drawn(board);
   // enemy.drawn(board);
    
    timer.update(board,enemy,tower);
    
    
    
   

    

    }



       
    
}

