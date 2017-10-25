
package TD.data;


/**
 *TODO
- Crear proyectiles
- Disparar proyectiles 
- Creacion de torres por consola
 */
public class Tower extends Square {
    
    private int damage,range;
    
    public Tower(int row, int col, char value,int damage,int range) {
        super(row, col, value);
        this.damage=damage;
        this.range=range;
    }

    public int getDamage() {
        return damage;
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
}
