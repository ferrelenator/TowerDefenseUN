/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD.business;

import TD.data.*;

/**
 *
 * @author Fenryr
 */
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
                int x,y,w,z;
                x=t.getRow();y=t.getCol();
                w=e.getRow();z=e.getCol();
                if( (w>=(x-1)) && (w<=(x+1)) && (z>=(y-1)) && (z<=(y+1))){
                    e.setHealt(e.getHealt()-t.getDamage()); System.out.println("sirve");}
                else{System.out.println(" No sirve");   }
            }
        }
        for(int i =0; i < board.getEnemyList().size() ; i++){
            if(board.getEnemyList().get(i).getHealt()<= 0){board.getEnemyList().remove(i);}
        }
    }
    
    public void moveEnemy() {
        for(Enemy e : board.getEnemyList()) {
            if(8 <  (e.getRow() + e.getCol()) && (e.getRow() + e.getCol()) < 15 ){
                e.setCol(e.getCol()+1);
                System.out.println(e.getRow()+e.getCol());
            }
            if(4 < (e.getRow() + e.getCol()) && (e.getRow() + e.getCol()) < 9  ){
                e.setRow(e.getRow()+1);
                System.out.println(e.getRow()+e.getCol());}
            if((e.getRow()+e.getCol()) <5 ){
                e.setCol(e.getCol()+1);
                System.out.println(e.getRow()+e.getCol());}  
        }
    }
}
