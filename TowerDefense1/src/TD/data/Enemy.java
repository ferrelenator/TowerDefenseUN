/*
TODO
- Mover enemigo : Variable tiempo
- Los enemigos deben tener velocidad , vida
 */
package TD.data;


public class Enemy {
    

    private float x,y;
    
    
    public Enemy(float x, float y){
        this.x=x;
        this.y=y;
        
    }
    
       
    public void drawn(Board board){
    board.paint(x,y,'#');
    }
}
