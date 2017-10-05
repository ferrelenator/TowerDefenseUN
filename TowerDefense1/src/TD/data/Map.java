
package TD.data;

import TD.ui.UI;
import TD.data.*;

public class Map {
    
    private static Board board;
    public static void newMap() {
        
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
    UI.printFiles();
    UI.printBoard(board);
    }
}
