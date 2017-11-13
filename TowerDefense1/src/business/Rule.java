package business;

import data.*;
import ui.UI;

public class Rule {
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public UI getUi() {
        return ui;
    }
    public void setUi(UI ui) {
        this.ui = ui;
    }
    
    private Board board;
    private Player player;
    private UI ui;
    private int wave,waveMax;
    
    
    public Rule(Board board,Player player,UI ui){
        this.board=board;
        this.player=player;
        this.wave=0;
        this.waveMax=5;
        this.ui=ui;
    }
    
    public void master(int time){
    moveEnemy();  
    wave(time);
    attack();
    removeEnemy();
    }
    
    public void wave(int time){
        if(wave<waveMax){
        if(time%3 ==0){ 
            switch(wave){
                case 0:
                getBoard().newEnemy1(2,0); 
                getBoard().newEnemy1(3,0);
                break;
                case 1:
                getBoard().newEnemy1(2,0);
                getBoard().newEnemy1(2,0);
                getBoard().newEnemy1(3,0);
                break;
                case 2:
                getBoard().newEnemy1(2,0);
                getBoard().newEnemy1(2,0);
                getBoard().newEnemy1(3,0);
                getBoard().newEnemy1(3,0);
                break;
                case 3:
                getBoard().newEnemy2(2,0);
                getBoard().newEnemy2(3,0);
                break;
                case 4:
                getBoard().newEnemy2(2,0);
                getBoard().newEnemy2(2,0);
                getBoard().newEnemy2(3,0);
                getBoard().newEnemy2(3,0);
                break;
                default:
                break;} wave++;        
        }
        }
        
    }
    
    public void attack(){
       boolean first;
        for(Tower t: getBoard().getTowerList()){
            first=true;
            for(Enemy e: getBoard().getEnemyList()){
                if(first){
                if( (e.getRow()>=(t.getRow()-t.getRange())) && 
                    (e.getRow()<=(t.getRow()+t.getRange())) && 
                    (e.getCol()>=(t.getCol()-t.getRange())) && 
                    (e.getCol()<=(t.getCol()+t.getRange()))){
                    e.setHealth(e.getHealth()-t.getDamage());first=false;}
                }
            }  
        }  
    }
    
    public void moveEnemy() {
        for(Enemy e : getBoard().getEnemyList()) {
            if(8 <  (e.getRow() + e.getCol()) && (e.getRow() + e.getCol()) < 16 ){
                e.setCol(e.getCol()+1);}
            if(4 < (e.getRow() + e.getCol()) && (e.getRow() + e.getCol()) < 9  ){
                e.setRow(e.getRow()+1);}
            if((e.getRow()+e.getCol()) <5 ){
                e.setCol(e.getCol()+1);} 
        }
    }
    
    public void askTower(){
        boolean cont=true,cont2;
        if(getPlayer().getMoney()>=100){
            while(cont){
                cont2=true;
                int[] i =getUi().placeTower();
                for(Tower t: getBoard().getTowerList()){
                    if(t.getRow()==i[0] && t.getCol()==i[1]){
                        getUi().error(1);cont2=false;
                    }
                }
                if(cont2){
                    if(getBoard().getBoard()[i[0]][i[1]].getValue()=='X'){
                        getBoard().newTower1(getPlayer(), i[0], i[1]);
                        cont=false;}else{getUi().error(1);}
                }
            }
        }else{getUi().error(2);}
    }
    
    public void removeEnemy(){
        for(int j =0; j < getBoard().getEnemyList().size() ; j++){
            if((getBoard().getEnemyList().get(j).getRow() == 6 && getBoard().getEnemyList().get(j).getCol()== 9) ||
                 (getBoard().getEnemyList().get(j).getRow() == 7 && getBoard().getEnemyList().get(j).getCol()== 9)   ){
                getBoard().winEnemy(getPlayer(), j);
            }
            if(getBoard().getEnemyList().get(j).getHealth()<= 0){
                getUi().moneyEnemy(getBoard().getEnemyList().get(j));
                getBoard().killEnemy(getPlayer(), j);
            }
        }
    }
    public void removeTower(){
         int i = getUi().selectTower(getBoard());
         getUi().moneyTower(getBoard().getTowerList().get(i));
         getBoard().removeTower(getPlayer(), i);
    }
    public int getWave() {
        return wave;
    }
    public void setWave(int wave) {
        this.wave = wave;
    }
    public int getWaveMax() {
        return waveMax;
    }
    public void setWaveMax(int waveMax) {
        this.waveMax = waveMax;
    }
}
