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
import data.Board;
import data.Player;
import data.Texture;
import ui.UI;
import ui.UIText;
import ui.UISwing;
import ui.UITest;

public class Boot  {
    
    private static Board board;
    private static Player player;
    private static boolean cycle ;
    
    private static Rule rule;
    private static Turn turn;
    private static UI ui;
    
    
   private static void selectUI(String[] args) {
        if (args.length == 0) {
        //    ui = new UISwing();
           ui = new UIText(); 
            
        } else if (args[0].equals("text")) {
            ui = new UIText();
        } else {
      //      ui = new UISwing(new Board());
        }
    }

    public static void main(String[] args) {  
   selectUI(args); 
    Star();
    newGame();
    
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
       board=new Board();
       turn=new Turn(ui); 
      
       
    //   this.ui=new UISwing(board);
       player = new Player(ui.playerName());
       rule=new Rule(board,player,ui);
       
       turn.run();    
    }
    
    public void newMap(){
        Texture texture;
        char value;
        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap.length; j++) {
                switch(newMap[i][j]){
                    case 1:
                        value=' ';
                        break;
                    case 2:
                        value='~';
                        break;
                    case 3:
                        value='*';
                        break;
                    default:
                        value='X';
                        break;
                }
                Square square = new Square(i, j,value);
                board[i][j]=square;
            }
        }
    }
    
    
}
    
    
 

    





       
    


