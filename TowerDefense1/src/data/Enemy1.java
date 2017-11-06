/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Fenryr
 */
public class Enemy1 extends Enemy {
    
    public Enemy1(int row, int col) {
        super(row, col);
        super.setValue('#');
        super.setHealth(15);
        super.setSpeed(1);
        super.setMoney(15);  
        super.setDamage(1); 
    }
    
    
}
