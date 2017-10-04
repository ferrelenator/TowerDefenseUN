
package TD.data;

import TD.ui.UI;
import TD.data.*;

public class Map {
    
    private static Board board;
    private static Tower tower;
    private static Enemy enemy;
   
    public static void startGame() {
        
        int[][] map ={
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,0},
            {1,1,1,1,0,0,0,1,1,0},
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
    enemy = new Enemy(2,2,1);
    tower.drawn(board);
    enemy.drawn(board);
    UI.printFiles();
    UI.printBoard(board);
    
    }
}
