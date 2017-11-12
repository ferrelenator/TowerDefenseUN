package business;




import data.Board;
import data.Player;
import ui.UI;
public class Turn implements Runnable {
     
    private Board board;
    private Player player;
    private Rule rule;
    private int timeLimit=2;
    private int seconds=2;
    private int counter = 0 ;
    private boolean exit;
    private UI ui;

    
    public Turn(UI ui) {
       this.ui=ui;
       this.board=new Board();
       this.player = new Player(ui.playerName());
       this.rule=new Rule(board,player,ui);
    }
    
    public void stop() {
        setTimeLimit(-1);
    }
    
    @Override
    public void run() {
            try { 
             game();
            Thread.sleep(1000);
            counter++;                     
            } catch (InterruptedException ex) {  }
        
    }
    
    public void game() {
        exit = false;
        int user ;
        while (!exit) {
            exitG();
            user =ui.printMenu();
                ui.charge(board, player,counter);
            if(user!=9){
                switch(user){
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
                        exit=true;
                        break;  
                    case 8:
                        System.exit(0);
                        break;                         
                    default:
                        ui.error(0);
                        break;
                }
            }else{rule.master(counter);}
        }
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
    



