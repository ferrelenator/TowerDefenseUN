/*
TODO:

- Menu principal : un menu principal que permita Iniciar un nuevo juego, salir del juego 
- Crear el "tiempo"
- Pausar el tiempo o adelantarlo
- Crear Oleadas y manejo de oleadas

*/


package TD.business;

import TD.data.*;
import TD.ui.UI;
public class Boot  {
    
    private static Board board;
    private static Tower tower;
    private static Enemy enemy;
    public static void main(String[] args) {
        


        startGame();
    }

    private static void startGame() {
        int[][] map ={
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {1,1,1,1,0,0,0,0,0,0},
            {1,1,1,1,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,0},
            {0,0,1,1,1,1,1,1,1,1},
            {0,0,1,1,1,1,1,1,1,1},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
        };
    board = new Board(map);
    tower = new Tower(1,1);
    enemy = new Enemy(2,2);
    UI.printWelcome();
    tower.drawn(board);
    enemy.drawn(board);
    UI.printBoard(board);

    

    }



       
    
}

