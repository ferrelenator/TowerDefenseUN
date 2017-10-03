/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD.data;

import TD.ui.UI;


/**
 *
 * @author ferrelenator
 */
public class Wave {
    
    private int numberOfEnemies;
    private int numberOfWave;

    public Wave() {
     
    }
    
    
    
    Enemy enemy = new Enemy(4,0,1);
    
    
    
    public void moveEnemy (){
        for (int a = (int)enemy.getY() ; a == 9; a++){
            enemy.update(enemy.getX(),a);
        }
    }    
    
      public void update(Board board){
         int a=0;
          while ( a < board.getLength()) {
 
        enemy.drawn(board);
        UI.printBoard(board);
        board.paint(enemy.getX(),enemy.getY(),' ');
        enemy.setY(enemy.getY()+1);
        
        a++;
            }
    
}
