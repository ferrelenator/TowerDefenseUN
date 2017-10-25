package TD.business;



import TD.data.*;

public class Turn implements Runnable {
     
    private int timeLimit;
    private int counter = 0 ;
    private static Board board;
    private static Rule rule;
    private static Artist art;
    
    public Turn(int timeLimit,Board board,Artist art,Rule rule) {
        this.timeLimit = timeLimit;
        Turn.board=board;
        Turn.art=art;
        Turn.rule=rule;
    }
    
    public void stop() {
        setTimeLimit(-1);
    }
    
    @Override
    public void run() {
        while (getCounter() < this.getTimeLimit()) {
            try {          
                rule.spawn(counter);
                art.paint(board);
                System.out.println(art.getPrintBoard());  
                System.out.println(counter); 
                counter++;
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
    



