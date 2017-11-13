package data;

import java.awt.image.BufferedImage;

public class Enemy {
    
    private Square square;
    private int health,speed,money,damage;
    
    
    public Enemy(int row, int col,char value,int health,int speed,int money,int damage,BufferedImage image){
      this.square=new Square(row,col,value,image);  
      this.health=health;
      this.speed=speed;
      this.money=money;
      this.damage=damage;
    }
    
    public int getRow(){
        return getSquare().getRow();
    }
    public void setRow(int i){
        getSquare().setRow(i);
    }
    public int getCol(){
        return getSquare().getCol();
    }
    public void setCol(int i){
        getSquare().setCol(i);
    }  
    public char getValue(){
        return getSquare().getValue();
    }
    public void setValue(char i){
        getSquare().setValue(i);
    } 
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int healt) {
        this.health = healt;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * @return the square
     */
    public Square getSquare() {
        return square;
    }

    /**
     * @param square the square to set
     */
    public void setSquare(Square square) {
        this.square = square;
    }
}
