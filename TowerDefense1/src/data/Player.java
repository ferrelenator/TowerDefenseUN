
package data;

public class Player {
    
    private int money,life;
    
    public Player(){
        this.life=5;
        this.money=200;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
}
