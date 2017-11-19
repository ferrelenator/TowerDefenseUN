package business;




import data.Board;
import data.Player;
import ui.UI;
public class Turn implements Runnable {
     
    private Board board;
    private Player player;
    private Rule rule;
    private int timeLimit=2;
    private int counter = 0 ;
    private boolean exit;
    private UI ui;

    
    public Turn(Rule rule) {
        this.rule=rule;
        this.board=rule.getBoard();
        this.player=rule.getPlayer();
        this.ui=rule.getUi();
    }
    
    public void pause() {
        setTimeLimit(-1);
    }
    
    public void resume(){
        setTimeLimit(2);
    }
    
    @Override
    public void run() {
        setExit(false);
        ui.printBoard(board);
        while(!isExit()){
        while(timeLimit>1){
            exitG();
            if(!isExit()){
             game();
             ui.charge(board, player,counter);
            try{
            Thread.sleep(1000);
            counter++; } catch (InterruptedException ex) {  }
            } else{}          
        }
        }
    }
    
    public void game() {
    switch(ui.printMenu()){
                    case 1:
                        rule.master(counter);  
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
                        setExit(true);
                        pause();
                        break;  
                    case 8:
                        System.exit(0);
                        break;                         
                    default:
                        ui.error(0);
                        break;
                }
            }
    
     public void exitG(){
        if(rule.getWave()==rule.getWaveMax() && board.getEnemyList().isEmpty()){
            setExit(true);
            pause();
            ui.win();
        }
        if(player.getLife()<= 0){
            setExit(true);
            pause();
            ui.loose();
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

    public boolean isExit() {
        return exit;
    }
    public void setExit(boolean exit) {
        this.exit = exit;
    }
}
    



