package business;




import data.Board;
import data.Player;
import ui.UI;
import ui.UISwing;
public class Turn implements Runnable {
     
    private Board board;
    private Player player;
    private Rule rule;
    private int timeLimit=2;
    private int seconds=2;
    private int counter = 0 ;
    private boolean exit;
    private int user;
    private UI ui;

    
    public Turn(UI ui) {
 
       
       
    }
    
    public void stop() {
        setTimeLimit(-1);
    }
    
    public void resume(){
        setTimeLimit(2);
    }
    
    @Override
    public void run() {
        exit = false;
        while(timeLimit>1){
            ui.printBoard(board);
            try { 
            exitG();
            if(!exit){
             game();
            System.out.println("si llega"); 
            Thread.sleep(1000);
            counter++;         } else{System.out.println("acabo");}          
            } catch (InterruptedException ex) {  }
        }
    }
    
    public void game() {
      
            user=9;           
     user =ui.printMenu();
            if(user!=9){
                switch(user){
                    case 1:
                        rule.master(counter);  
                        ui.charge(board, player,counter);
                        break;
                    case 2:
                        rule.askTower();
                        break;
                    case 3:
                        rule.removeTower();
                        break;
                    case 4:
                        ui.infoPlayer(player);
                        break;
                    case 5:
                        ui.infoTower(board);
                        break;
                    case 6:
                        ui.infoEnemy(board);
                        break;    
                    case 7:
                        exit=true;
                        break;  
                    case 8:
                        System.exit(0);
                        break;                         
                    default:
                        ui.error(0);
                        break;
                }
            }else{rule.master(counter);
            ui.charge(board, player,counter);}
        
    }
    
     public void exitG(){
        if(rule.getWave()==rule.getWaveMax() && board.getEnemyList().isEmpty()){
            exit=true;
            ui.win(0);
        }
        if(player.getLife()<= 0){
            exit=true;
            ui.win(1);
        }
    }
    
    public void newMap(){
        
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
    



