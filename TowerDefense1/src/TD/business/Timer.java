/*package TD.business;

import TD.data.*;
import TD.ui.UI;
import java.*;

public class Timer implements Runnable {
    
    private int timeLimit;
    private int counter = 0 ;
    public Timer(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void stop() {
        timeLimit = -1;
    }

    @Override
    public void run() {

        
        
        while (getCounter() < this.timeLimit) {
            try {
                counter++;
                Thread.sleep(1000);
                
//                System.out.println(counter);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }
    
    public void update(Board board,Enemy enemy, Tower tower){
         while (getCounter() < this.timeLimit) {
            try {
        Thread.sleep(1000);
        tower.drawn(board);
        enemy.drawn(board);
        UI.printBoard(board);
        board.paint(enemy.getX(),enemy.getY(),' ');
        enemy.setY(enemy.getY()+1);

        
    } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }  
    

    

    
    //@return the counter
     
    public int getCounter() {
        return counter;
    }
    
    
}
*/