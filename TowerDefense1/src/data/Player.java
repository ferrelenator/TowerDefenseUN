
package data;

public class Player {
    
    private int money,life;
    private String name;
    public Player(String name){
        this.life=5;
        this.money=300;
        this.name=name;
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
