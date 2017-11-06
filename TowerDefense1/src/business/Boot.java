/*
TO DO:
- Tipos de torres 
- Tipos de enemigos
- Actualizar torres
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
import ui.UI;
import ui.UIText;


public class Boot  {
    
    private static Board board;
    private static Player player;
    private static Turn turn;
    private static Rule rule;
    private static UI ui;
    private static boolean cycle ;
    private static boolean  exit;
    
    public static void main(String[] args) {  
         if (args.length == 0) {
            ui = new UIText();
        } else if (args[0].equals("text")) {
            ui = new UIText();
        } else {
            ui = new UIText();
        }
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
                case 4:
                    ui.credits();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                   ui.error(0);        
            }
        }
    }

    public static void newGame() {
        board=new Board();
        player = new Player(ui.playerName());
        rule=new Rule(board,player,ui);
        turn=new Turn(1);
        game();    
    }
    public static void game() {
        exit = false;
        int user =0;
        while (!exit) {
            exitG();
            if(!exit){
                ui.update(board, player, turn);
                if(user!=9){
                    user =ui.printMenu();
                }
                switch(user){
                    case 1:
                        turn.run();  
                        rule.master(turn.getCounter());     
                        break;
                    case 2:
                        rule.askTower();
                        break;
                    case 3:
                        rule.removeTower();
                        break;
                    case 4:
                        ui.infoPlayer(player);
                        break;
                    case 5:
                        ui.infoTower(board);
                        break;
                    case 6:
                        ui.infoEnemy(board);
                        break;    
                    case 7:
                        exit=true;
                        break;  
                    case 8:
                        System.exit(0);
                        break;                         
                    case 9:
                        turn.run();
                        rule.master(turn.getCounter());
                        break;
                    default:
                        ui.error(0);
                        break;
                }
            }
        }
    }
        
 public static void exitG(){
        if(rule.getWave()==rule.getWaveMax() && board.getEnemyList().isEmpty()){
            exit=true;
            ui.win(0);
        }
        if(player.getLife()<= 0){
            exit=true;
            ui.win(1);
        }
    }
}
    
    
 

    





       
    


