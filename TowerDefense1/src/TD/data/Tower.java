
package TD.data;

/**
 *TODO
- Crear proyectiles
- Disparar proyectiles 
- Creacion de torres por consola
 */
public class Tower {
    
    private float x,y;
    
    
    public Tower(float x, float y){
        this.x=x;
        this.y=y;
        
    }
    
       
    public void drawn(Board board){
        board.paint(x,y,'O');
    }


}
