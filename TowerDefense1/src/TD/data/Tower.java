
package TD.data;

/**
 *
 * @author Fenryr
 */
public class Tower {
    
    private int x,y;
    
    
    public Tower(int x, int y){
        this.x=x;
        this.y=y;
        
    }
    
       
    public void drawn(Board board){
    board.paint(x,y,'O');
    }
}
