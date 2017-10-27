/*
TO DO
- Mover enemigo : Variable tiempo
- Los enemigos deben tener velocidad , vida
 */
package data;

public class Enemy {
    
    private Square square;
    private int health,speed,money,damage;
    
    public Enemy(int row, int col){
        enemy1(row,col);
         
    }
    
    public void enemy1(int row,int col){
        this.square= new Square(row,col,'#');
        this.health=2;
        this.speed=1;
        this.money=15;  
        this.setDamage(1);
    }
    
        public int getRow(){
        return square.getRow();
    }
    public void setRow(int i){
        square.setRow(i);
    }
    public int getCol(){
        return square.getCol();
    }
    public void setCol(int i){
        square.setCol(i);
    }  
    public char getValue(){
        return square.getValue();
    }
    public void setValue(char i){
        square.setValue(i);
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
}
