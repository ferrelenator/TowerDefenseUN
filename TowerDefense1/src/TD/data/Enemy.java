/*
TO DO
- Mover enemigo : Variable tiempo
- Los enemigos deben tener velocidad , vida
 */
package TD.data;

public class Enemy extends Square {

    private int health,speed;
    
    public Enemy(int x, int y,char value,int speed,int health){
        super(x,y,value);
        this.speed=speed;
        this.health=health;
         
    }
    
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public int getHealt() {
        return health;
    }
    public void setHealt(int healt) {
        this.health = healt;
    }

  
}
