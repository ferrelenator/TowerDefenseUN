package TD.business;

import TD.data.*;
import TD.ui.UI;

public class Rule {
    
    private  Board board;
    
    public Rule(Board board){
        this.board=board;
    }
    
    public void master(int time){
    moveEnemy();  
    spawn(time);
    attack();
    
    }
    public void spawn(int time){
        if(time%4 ==0){ 
            board.newEnemy(2,0);   
        }    
    }
    public void attack(){
       int x,y,w,z,k; 
       boolean first;
        for(Tower t: board.getTowerList()){
            first=true;
            for(Enemy e: board.getEnemyList()){
                if(first){
                x=t.getRow();y=t.getCol();
                w=e.getRow();z=e.getCol();
                k=t.getRange();
                if( (w>=(x-k)) && (w<=(x+k)) && (z>=(y-k)) && (z<=(y+k))){
                    e.setHealt(e.getHealt()-t.getDamage());first=false;}
                }
            }
        }
        for(int i =0; i < board.getEnemyList().size() ; i++){
            if(board.getEnemyList().get(i).getHealt()<= 0){board.getEnemyList().remove(i);}
        }
    }
    
    public void moveEnemy() {
        for(Enemy e : board.getEnemyList()) {
            if(8 <  (e.getRow() + e.getCol()) && (e.getRow() + e.getCol()) < 15 ){
                e.setCol(e.getCol()+1);}
            if(4 < (e.getRow() + e.getCol()) && (e.getRow() + e.getCol()) < 9  ){
                e.setRow(e.getRow()+1);}
            if((e.getRow()+e.getCol()) <5 ){
                e.setCol(e.getCol()+1);} 
        }
    }
    public void askTower(){
        boolean cont=true;
        while(cont){
        int[] i =UI.tower();
        if(board.getBoard()[i[0]][i[1]].getValue()=='X'){
            board.newTower( i[0], i[1]);
            cont=false;
        }else{UI.error(1);}}
    }

}
