/*
TO DO
- Mover enemigo : Variable tiempo
- Los enemigos deben tener velocidad , vida
 */
package TD.data;

public class Enemy {
    
    private float x,y,speed;
    private float counter=0;
    
    public Enemy(float x, float y,float speed){
        this.x=x;
        this.y=y;
        this.speed=speed;
        
    }
    
    public void drawn(Board board){
    board.paint(x,y,'#');
    }
    

    
    
    
    
    
    
    
    
    
      public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
