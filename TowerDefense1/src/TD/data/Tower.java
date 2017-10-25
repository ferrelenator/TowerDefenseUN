
package TD.data;


/**
 *TODO
- Crear proyectiles
- Disparar proyectiles 
- Creacion de torres por consola
 */
public class Tower extends Square {
    
    private int damage;
    
    public Tower(int row, int col, char value,int damage) {
        super(row, col, value);
        this.damage=damage;
    }

    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
