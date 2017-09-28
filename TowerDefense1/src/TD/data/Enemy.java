/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD.data;

/**
 *
 * @author Fenryr
 */
public class Enemy {
    

    private int x,y;
    
    
    public Enemy(int x, int y){
        this.x=x;
        this.y=y;
        
    }
    
       
    public void drawn(Board board){
    board.paint(x,y,'#');
    }
}
