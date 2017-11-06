package business;



import ui.UIText;
public class Turn implements Runnable {
     
    private int timeLimit=2;
    private int seconds=2;
    private int counter = 0 ;

    
    public Turn(int seconds) {
    }
    
    public void stop() {
        setTimeLimit(-1);
    }
    
    @Override
    public void run() {
            try { 
            Thread.sleep(1000);
            counter++;                     
            } catch (InterruptedException ex) {
                ex.printStackTrace();             
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
    



