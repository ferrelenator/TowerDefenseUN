package business;



import data.*;
import ui.UI;
public class Turn implements Runnable {
     
    private int timeLimit;
    private int counter = 0 ;
    private static Board board;
    private static Rule rule;
    private static Player player;
    
    public Turn(int timeLimit,Board board,Rule rule,Player player) {
        this.timeLimit = timeLimit;
        Turn.board=board;
        Turn.rule=rule;
        Turn.player=player;
    }
    
    public void stop() {
        setTimeLimit(-1);
    }
    
    @Override
    public void run() {
        boolean exit = false;
        boolean exit2;
        int user =0;
        while (!exit) {
            try {
            exit2=exitG();
            if(!exit2){
                UI.printBoard(board);
                UI.infoPlayer(player);   
                if(user!=9){
                    UI.printMenu();
                    user =UI.readerInt();}
                switch(user){
                    case 1:
                        rule.master(counter);                 
                        Thread.sleep(1000);
                        counter++;
                        UI.time(counter);
                        break;
                    case 2:
                        rule.askTower();
                        break;
                    case 3:
                        rule.removeTower();
                        break;
                    case 4:
                        UI.infoPlayer(player);
                        break;
                    case 5:
                        UI.infoTower(board);
                        break;
                    case 6:
                        UI.infoEnemy(board);
                        break;    
                    case 7:
                        exit=true;
                        break;  
                    case 8:
                        System.exit(0);
                        break;                         
                    case 9:
                        rule.master(counter);                 
                        Thread.sleep(1000);
                        counter++;
                        UI.time(counter);
                        break;
                    default:
                        UI.error(0);
                        break;
                }
            }else{exit=true;}
            } catch (InterruptedException ex) {
                ex.printStackTrace();             
                }
        }   
    }
    
    public boolean exitG(){
        boolean exit=false;
        if(rule.getWave()==rule.getWaveMax() && board.getEnemyList().isEmpty()){
            exit=true;
            UI.win(0);
        }
        if(player.getLife()<= 0){
            exit=true;
            UI.win(1);
        }
        return exit;
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
    



