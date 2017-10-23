package TD.business;



import TD.data.*;
import TD.ui.UI;

public class Turn implements Runnable {

     
    private int timeLimit;
    private int counter = 0 ;
    private static Board board;
    private static Array array;
    private static Artist art;
    
    public Turn(int timeLimit,Board board,Array array,Artist art) {
        this.timeLimit = timeLimit;
        Turn.board=board;
        Turn.array=array;
        Turn.art=art;
    }

    public void stop() {
        setTimeLimit(-1);
    }

    @Override
    public void run() {
        while (getCounter() < this.getTimeLimit()) {
            try {
              
            
           array.spawn(counter);
            art.paint(board, array);
            array.moveEnemy();
           System.out.println(art.getPrintBoard());
            System.out.println(counter);
            
            counter++;
            Thread.sleep(1000); 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

    }

    
    //@return the counter
     
    public int getCounter() {
        return counter;
    }

    /**
     * @return the timeLimit
     */
    public int getTimeLimit() {
        return timeLimit;
    }

    /**
     * @param timeLimit the timeLimit to set
     */
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
    



