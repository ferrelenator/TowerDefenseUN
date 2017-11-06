package data;

public class Enemy {
    
    private Square square;
    private int health,speed,money,damage;
    
    public Enemy(int row, int col){
        this.square= new Square(row,col,'E');
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
