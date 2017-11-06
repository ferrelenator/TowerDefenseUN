package business;

import data.*;
import ui.UI;

public class Rule {
    
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
                board.newEnemy1(2,0); 
                board.newEnemy1(3,0);
                break;
                case 1:
                board.newEnemy1(2,0);
                board.newEnemy1(2,0);
                board.newEnemy1(3,0);
                break;
                case 2:
                board.newEnemy1(2,0);
                board.newEnemy1(2,0);
                board.newEnemy1(3,0);
                board.newEnemy1(3,0);
                break;
                case 3:
                board.newEnemy2(2,0);
                board.newEnemy2(3,0);
                break;
                case 4:
                board.newEnemy2(2,0);
                board.newEnemy2(2,0);
                board.newEnemy2(3,0);
                board.newEnemy2(3,0);
                break;
                default:
                break;} wave++;        
        }
        }
        
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
                int[] i =ui.placeTower();
                for(Tower t: board.getTowerList()){
                    if(t.getRow()==i[0] && t.getCol()==i[1]){
                        ui.error(1);cont2=false;
                    }
                }
                if(cont2){
                    if(board.getBoard()[i[0]][i[1]].getValue()=='X'){
                        board.newTower(player, i[0], i[1]);
                        cont=false;}else{ui.error(1);}
                }
            }
        }else{ui.error(2);}
    }
    
    public void removeEnemy(){
        for(int j =0; j < board.getEnemyList().size() ; j++){
            if((board.getEnemyList().get(j).getRow() == 6 && board.getEnemyList().get(j).getCol()== 9) ||
                 (board.getEnemyList().get(j).getRow() == 7 && board.getEnemyList().get(j).getCol()== 9)   ){
                board.winEnemy(player, j);
            }
            if(board.getEnemyList().get(j).getHealth()<= 0){
                ui.moneyEnemy(board.getEnemyList().get(j));
                board.killEnemy(player, j);
            }
        }
    }
    public void removeTower(){
         int i = ui.selectTower(board);
         ui.moneyTower(board.getTowerList().get(i));
         board.removeTower(player, i);
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
