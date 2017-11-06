
package data;


/**
 *TODO
- Crear proyectiles
- Disparar proyectiles 
 */
public class Tower {
    
    private Square square;
    private Player player;
    private int damage,range,price,sell;
    
    public Tower(Player player,int row,int col) {
        tower1(row,col);
        this.sell= price/2;
        player.setMoney(player.getMoney()-price);
    }
    
    
    public void tower1(int x,int y){
        this.setSquare(new Square(x,y,'O'));
        this.damage=10;
        this.price=100;
        this.range=1;
    }
    
    public int getDamage() {
        return damage;
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
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range) {
        this.range = range;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int money) {
        this.price = money;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }
    public Square getSquare() {
        return square;
    }
    public void setSquare(Square square) {
        this.square = square;
    }
}
