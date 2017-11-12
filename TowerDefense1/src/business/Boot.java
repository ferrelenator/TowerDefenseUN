/*
TO DO:
-Logica del jeugo en cuanto a JUGABILIDAD es decir OLEADAS DAÑO DINERO
- Actualizar torres
-Cuadrar los metodos de UISwing()
    -UISwing usa la ayuda de gui de NETBEANS
    -UISwing2 no la usa esta es para personalizar el tablero
    - al final la idea es juntar ambas y lograr una sola UISwing pero para eso toca editar el codigo
    -UISwing() y romepria el editor grafico de Netbeans se ahce al final cuando ya ete funcionando
- Crear Oleadas y manejo de oleadas
- Pausar el tiempo o adelantarlo
- verificar metodo para hacer mover al enemigo esta en Rule moveEnemy()
- verificar metodo el rango de la torre esta en Rule attack()
- Cuadrar los metodos de UIText por si el usuario ingresa letras o otras cosas que 
no sean numeros
- Actualizar los diagramas de actividades, de clase, los Mockups 
*/

package business;
import ui.UI;
import ui.UIText;
import ui.UISwing;

public class Boot  {
    
    
    private static Turn turn;
    private static UI ui;
    private static boolean cycle ;
    
     private static void selectUI(String[] args) {
        if (args.length == 0) {
            ui = new UISwing();
            
        } else if (args[0].equals("text")) {
            ui = new UIText();
        } else {
            ui = new UISwing();
        }
    }
 
    public static void main(String[] args) {  
    selectUI(args); 
   Star();
    }
    
    public static void Star(){
        cycle=true;
        
        while(cycle){
            int userOpt =ui.printTitle();
            switch(userOpt){
                case 1:
                   newGame();             
                    break;
                case 2:
                    ui.instructions();
                    break;
                case 3:
                    ui.credits();
                    break;
                case 4:
                    System.exit(0);
                    break;
                }
        }
    }
    public static void newGame() {
       
       turn=new Turn(ui); 
       turn.game();    
    }
}
    
    
 

    





       
    


