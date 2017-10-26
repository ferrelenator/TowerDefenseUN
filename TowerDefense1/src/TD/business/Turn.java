package TD.business;



import TD.data.*;
import TD.ui.UI;
public class Turn implements Runnable {
     
    private int timeLimit;
    private int counter = 0 ;
    private static Board board;
    private static Rule rule;
    
    public Turn(int timeLimit,Board board,Rule rule) {
        this.timeLimit = timeLimit;
        Turn.board=board;
        Turn.rule=rule;
    }
    
    public void stop() {
        setTimeLimit(-1);
    }
    
    @Override
    public void run() {
        while (getCounter() < this.getTimeLimit()) {
            try {          
                rule.master(counter);
                UI.printBoard(board);
                System.out.println(counter); 
                counter++;
        //        UI.infoEnemy(board); UI.readerInt();
                Thread.sleep(1000); 
                } catch (InterruptedException ex) {
                ex.printStackTrace();             
                }
        }   
    }
     
    public int getCounter() {
        return counter;
    }
    public void setCounter(int counter) {
        this.counter=counter;
    }
    public int getTimeLimit() {
        return timeLimit;
    }
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
}
    



