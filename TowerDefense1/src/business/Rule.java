package business;

import data.*;
import ui.UI;

public class Rule {
    
    private Board board;
    private Player player;
    private int wave,waveMax;
    
    public Rule(Board board,Player player){
        this.board=board;
        this.player=player;
        this.wave=0;
        this.waveMax=3;
    }
    
    public void master(int time){
    moveEnemy();  
    wave(time);
    if(!board.getEnemyList().isEmpty()){
        attack();
        removeEnemy();
    }
    }
    
    
    public void wave(int time){
        if(wave<getWaveMax()){
        if(time%2 ==0){ 
        wave++;
        board.newEnemy(2,0); 
        board.newEnemy(3,0);  
        }}
        
    }
    
    public void attack(){
       boolean first;
        for(Tower t: board.getTowerList()){
            first=true;
            for(Enemy e: board.getEnemyList()){
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
        for(Enemy e : board.getEnemyList()) {
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
        if(player.getMoney()>=100){
            while(cont){
                cont2=true;
                int[] i =UI.placeTower();
                for(Tower t: board.getTowerList()){
                    if(t.getRow()==i[0] && t.getCol()==i[1]){
                        UI.error(1);cont2=false;
                    }
                }
                if(cont2){
                    if(board.getBoard()[i[0]][i[1]].getValue()=='X'){
                        board.newTower(player, i[0], i[1]);
                        cont=false;}else{UI.error(1);}
                }
            }
        }else{UI.error(2);}
    }
    
    public void removeEnemy(){
        for(int j =0; j < board.getEnemyList().size() ; j++){
            if((board.getEnemyList().get(j).getRow() == 6 && board.getEnemyList().get(j).getCol()== 9) ||
                 (board.getEnemyList().get(j).getRow() == 7 && board.getEnemyList().get(j).getCol()== 9)   ){
                board.winEnemy(player, j);
            }
            if(board.getEnemyList().get(j).getHealth()<= 0){
                board.killEnemy(player, j);
            }
        }
    }
    public void removeTower(){
         int i = UI.selectTower(board);
         board.removeTower(player, i);
    }
    public int getWave() {
        return wave;
    }
    public void setWave(int wave) {
        this.wave = wave;
    }

    /**
     * @return the waveMax
     */
    public int getWaveMax() {
        return waveMax;
    }

    /**
     * @param waveMax the waveMax to set
     */
    public void setWaveMax(int waveMax) {
        this.waveMax = waveMax;
    }
}
