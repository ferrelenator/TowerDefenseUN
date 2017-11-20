/*
TO DO:
-Logica del jeugo en cuanto a JUGABILIDAD es decir OLEADAS DAÑO DINERO
- Actualizar torres
-Cuadrar los metodos de UISwing()
    -UISwing usa la ayuda de gui de NETBEANS
- Crear Oleadas y manejo de oleadas
- Pausar el tiempo o adelantarlo
- Cuadrar los metodos de UIText por si el usuario ingresa letras o otras cosas que 
no sean numeros
*/

package business;
import data.Board;
import data.Player;
import data.Texture;
import java.awt.image.BufferedImage;
import ui.UI;
import ui.UIText;
import ui.UISwing;

public class Boot  {
    
    private static Texture texture;
    private static Board board;
    private static Player player;
    private static boolean cycle=true;
    
    private static Rule rule;
    private static Turn turn;
    private static UI ui;
    
    
   private static void selectUI(String[] args) {
        if (args.length == 0) {
           ui = new UISwing();
        //   ui = new UIText(); 
            
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
        texture= new Texture();
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
       board=new Board(texture);
       newMap(board,texture);
       player = new Player(ui.playerName());
       rule=new Rule(board,player,ui);
       turn=new Turn(rule); 
       ui.newGame(board,player,turn);
       turn.run();    
    }
    
    public static void newMap(Board board,Texture texture){
        
        BufferedImage image;
        char value;
        for (int i = 0; i < board.getMap().getSize(); i++) {
            for (int j = 0; j < board.getMap().getSize(); j++) {
                switch(board.getMap().getMap()[i][j]){
                    case 1:
                        value='X';image=texture.getGrass();
                        break;
                    case 2:
                        value=' ';image=texture.getRoad();
                        break;
                    case 3:
                        value=' ';image=texture.getRoad3();
                        break;
                    case 4:
                        value=' ';image=texture.getRoad4();
                        break;
                    case 5:
                        value=' ';image=texture.getRoad5();
                        break;
                    case 6:
                        value=' ';image=texture.getRoad6();
                        break;
                    case 7:
                        value=' ';image=texture.getRoad7();
                        break;
                    case 8:
                        value=' ';image=texture.getRoad8();
                        break;  
                    case 9:
                        value=' ';image=texture.getRoad9();
                        break;  
                    case 10:
                        value=' ';image=texture.getRoad10();
                        break;      
                    default:
                        value='X';image=texture.getGrass();
                        break;
                }
                board.newBoard(i, j, value, image);
            }
        }
    }
    
    
}
    
    
 

    





       
    


