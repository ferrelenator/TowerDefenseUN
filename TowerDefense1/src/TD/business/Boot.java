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

    board = new Board();
    tower = new Tower(1,1);
    enemy = new Enemy(2,2);
    UI.printWelcome();
    board.road();
    tower.drawn(board);
    enemy.drawn(board);
    UI.printBoard(board);

    

    }



       
    
}

