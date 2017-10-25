package TD.business;

import TD.data.*;

public class Rule {
    
    private  Board board;
    
    public Rule(Board board){
        this.board=board;
    }
    
    public void spawn(int time){
    moveEnemy();  
    if(time%4 ==0){ 
    board.newEnemy(2,0);   
    }
    attack();
    }
    
    public void attack(){
        for(Enemy e: board.getEnemyList()){
            for(Tower t: board.getTowerList()){
                int x,y,w,z,k;
                x=t.getRow();y=t.getCol();
                w=e.getRow();z=e.getCol();
                k=t.getRange();
                if( (w>=(x-k)) && (w<=(x+k)) && (z>=(y-k)) && (z<=(y+k))){
                    e.setHealt(e.getHealt()-t.getDamage());}
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
}
