/*
TO DO
- Mover enemigo : Variable tiempo
- Los enemigos deben tener velocidad , vida
 */
package TD.data;

public class Enemy extends Square {
    
    private int healt,speed;
    

    
    public Enemy(int x, int y,char value,int speed){
        super(x,y,value);
        this.speed=speed;
         
    }
    
    public boolean alive(Enemy enemy){
        if(healt == 0){
           return false; 
        }else{return true;}
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
