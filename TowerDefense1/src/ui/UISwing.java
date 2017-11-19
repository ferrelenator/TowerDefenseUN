/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import business.Turn;
import data.Board;
import data.Enemy;
import data.Player;
import data.Tower;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ui.UISwing.GameBoard;
public class UISwing extends JFrame implements UI {
    
    private GameBoard myBoard;
    private Board board;
    private Player player;
    private Turn turn;

    private int select,x,y,type;

    private boolean think=false,first=false;
 
    public UISwing() {
        initComponents();
        //Dimmension(832,640);
        Menu.setVisible(true);
        Game.setVisible(false);
        Pause.setVisible(false);
        this.pack();
        this.setVisible(true);
      
    }
    


    @Override
    public void newGame(Board board, Player player,Turn turn) {
    this.board=board;
    this.player=player;
    this.turn=turn;
    LIcongold.setIcon(new ImageIcon("src/resources/Gold.png"));
    LIconlife.setIcon(new ImageIcon("src/resources/heart.png"));
    LIcontime.setIcon(new ImageIcon("src/resources/hourglass.png"));
    if(!first){
    first=true;
    myBoard=new GameBoard();
    panelBoard.add(myBoard);
    myBoard.setVisible(true);
    myBoard.setEnabled(true);
    this.revalidate();}
    this.repaint();
    
    }

    @Override
    public int Typetower() {
    return type;  
    }

    class GameBoard extends JPanel implements Runnable,ImageObserver{
        
        private int timeLimit=2;
        public Thread thread= new Thread(this);
        Dimension size=new Dimension(640,640);
       
        public GameBoard(){
        setPreferredSize(size);
        }
        
        public void stop() {
        timeLimit=-1;
        }
        public void resume(){
        timeLimit=2;
        }
        @Override
        public void run() {
            while(!think){
          
            }
        }
        
        @Override
        protected void paintComponent(Graphics g){
         super.paintComponent(g);      
          
        for (int row = 0; row < board.getBoard().length; row++) {
                for (int col = 0; col < board.getBoard().length; col++) {
                 board.getBoard()[row][col].draw(g, this);
            }}
        board.getTowerList().forEach((t) -> {
            t.getSquare().draw(g,this);
        });
        board.getEnemyList().forEach((e) -> {
            e.getSquare().draw(g,this);
        }); 
        
        }

    }
     
    private void pause() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            Logger.getLogger(UISwing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int printTitle() {
         Menu.setVisible(true);
         think=true;
          while (think) {
            pause();
        }
       return select;
    }

    @Override
    public void instructions() {
    JOptionPane.showMessageDialog(
                    this,
            "Tower defense es un juego de estrategia\n" +
"      utilizando torres ubicadas con coordenadas\n" +
"    debe derrotar a las oleadas de enemigos antes\n" +
"de que lleguen al final del camino, puede recolectar\n" +
"  dinero con cada baja, y asi mejorar sus defensas\n" +
"      El jugador gana si completa las oleadas\n" +
"      El jugador pierde si su vida es = a 0"     ,   
                          "Instrucciones",
                    JOptionPane.INFORMATION_MESSAGE
                  );    
        think=true;
    }

    @Override
    public void credits() {
         JOptionPane.showMessageDialog(
                        this,
                        "   Tower Defense fue desarrollado por     \n" +
"        -Nombre\n" +
"        -Nombre\n" +
"        -Nombre\n" +
"        -Daniel Aguirre Calvo\n",   
                        "Creditos",
                    JOptionPane.INFORMATION_MESSAGE
                  ); 
         think=true;
        }

    @Override
    public int printMenu() {
      while(think){
         pause(); 
         
      }
          return select;
       
    }

    @Override
    public String playerName() {
        return "Player";
    }

    @Override
    public void charge(Board board, Player player, int second) {
        Lgold.setText(Integer.toString(player.getMoney()));
        Llife.setText(Integer.toString(player.getLife()));
        Ltime.setText(Integer.toString(turn.getCounter()));
        repaint();
    }

    @Override
    public int[] placeTower() {
        think=true;
        x=0;
        y=0;
        select=1;
        while(think){
            pause();
            repaint();
        }
         int[]   ij= new  int[]{y,x};
        return ij;
    }

    @Override
    public void moneyEnemy(Enemy enemy) {
        Lstatus.setText("Enemigo "+" Derrotado, ganas " 
                 +enemy.getMoney()+" de oro. \n");
      }

    @Override
    public void moneyTower(Tower tower) {
        Lstatus.setText("Torre "+tower.getValue()+" Destruida , ganas " 
                 + tower.getSell() +" de oro. \n");
        }

    @Override
    public int selectTower(Board board) {
        think=true;
        int k =0;
        x=0;
        y=0;
        select=1;
        while(think){
            pause();
            repaint();
           int[]   ij= new  int[]{y,x}; 
            for(Tower t:board.getTowerList()) {
              if( t.getRow()==ij[0] && t.getCol()==ij[1] ){
                  k= board.getTowerList().indexOf(t);
                  think=false;
                  break;
              }else{think=true;}
            }
        }
        return k;}

    @Override
    public void moneyTower(Tower tower, int i) {
      Lstatus.setText("Torre Colocada  pierdes" 
                 +tower.getPrice()+" de oro. \n"); }

    @Override
    public void infoTime(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void infoPlayer(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void infoEnemy(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void infoTower(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(int i) {
        switch(i){
            case 0:
                System.out.println("\n Solo estan las opciones 1 , 2 , 3 , 4\n");
                break;
            case 1:
                Lstatus.setText("\n La torre no se puede colocar hay\n");
                break;
            case 2:
                Lstatus.setText("\n No hay suficiente dinero para comprar torres \n");
                select=1;
                think=false;
           
                break;    
        }
        }

    @Override
    public void win() {
         Game.setVisible(false);
          JOptionPane.showMessageDialog(
                        this,
                        "Ganaste"     ,   
                        "Victoria",
                    JOptionPane.INFORMATION_MESSAGE
                  ); 
        
        }
    @Override
    public void loose(){
      Game.setVisible(false);
      JOptionPane.showMessageDialog(
                        this,
                        "Perdiste"     ,   
                        "Derrota",
                    JOptionPane.INFORMATION_MESSAGE
                  ); 
    }
    @Override
    public void printBoard(Board board) {
       
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        Bmenu1 = new javax.swing.JButton();
        Bmenu2 = new javax.swing.JButton();
        Bmenu3 = new javax.swing.JButton();
        Bmenu4 = new javax.swing.JButton();
        Game = new javax.swing.JPanel();
        LIcongold = new javax.swing.JLabel();
        LIconlife = new javax.swing.JLabel();
        Btower1 = new javax.swing.JButton();
        Btower2 = new javax.swing.JButton();
        Bpause = new javax.swing.JButton();
        Lgold = new javax.swing.JLabel();
        Llife = new javax.swing.JLabel();
        panelBoard = new javax.swing.JPanel();
        Btower3 = new javax.swing.JButton();
        Lstatus = new javax.swing.JLabel();
        Ltime = new javax.swing.JLabel();
        LIcontime = new javax.swing.JLabel();
        Pause = new javax.swing.JPanel();
        Lpause = new javax.swing.JLabel();
        Bresume = new javax.swing.JButton();
        Bnew = new javax.swing.JButton();
        Bexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(850, 700));
        setMinimumSize(new java.awt.Dimension(850, 700));
        setSize(new java.awt.Dimension(850, 700));

        Menu.setBackground(new java.awt.Color(153, 255, 153));
        Menu.setMaximumSize(null);

        title.setFont(new java.awt.Font("Tempus Sans ITC", 0, 54)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Tower Defense");

        Bmenu1.setBackground(new java.awt.Color(153, 255, 204));
        Bmenu1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Bmenu1.setText("Nuevo Juego");
        Bmenu1.setToolTipText("");
        Bmenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bmenu1ActionPerformed(evt);
            }
        });

        Bmenu2.setBackground(new java.awt.Color(153, 255, 204));
        Bmenu2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Bmenu2.setText("Instrucciones");
        Bmenu2.setToolTipText("");
        Bmenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bmenu2ActionPerformed(evt);
            }
        });

        Bmenu3.setBackground(new java.awt.Color(153, 255, 204));
        Bmenu3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Bmenu3.setText("Creditos");
        Bmenu3.setToolTipText("");
        Bmenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bmenu3ActionPerformed(evt);
            }
        });

        Bmenu4.setBackground(new java.awt.Color(153, 255, 204));
        Bmenu4.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Bmenu4.setText("Salir");
        Bmenu4.setToolTipText("");
        Bmenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bmenu4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(0, 238, Short.MAX_VALUE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Bmenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bmenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bmenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bmenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(292, 292, 292))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(189, 189, 189))))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(Bmenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bmenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bmenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bmenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        Game.setBackground(new java.awt.Color(153, 255, 153));
        Game.setMaximumSize(null);

        LIcongold.setText("Oro");

        LIconlife.setText("Vida");

        Btower1.setBackground(new java.awt.Color(153, 255, 204));
        Btower1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/towerDefense_tile206.png"))); // NOI18N
        Btower1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btower1MouseClicked(evt);
            }
        });

        Btower2.setBackground(new java.awt.Color(153, 255, 204));
        Btower2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/towerDefense_tile249.png"))); // NOI18N
        Btower2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Btower2MouseClicked(evt);
            }
        });

        Bpause.setBackground(new java.awt.Color(153, 255, 204));
        Bpause.setText("Pausa");
        Bpause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BpauseActionPerformed(evt);
            }
        });

        Lgold.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Lgold.setText("Oro");

        Llife.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Llife.setText("Vida");

        panelBoard.setBackground(new java.awt.Color(153, 255, 204));
        panelBoard.setMaximumSize(new java.awt.Dimension(0, 0));
        panelBoard.setMinimumSize(new java.awt.Dimension(0, 0));
        panelBoard.setPreferredSize(null);
        panelBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBoardMouseClicked(evt);
            }
        });

        Btower3.setBackground(new java.awt.Color(153, 255, 204));
        Btower3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/recycle.png"))); // NOI18N
        Btower3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btower3ActionPerformed(evt);
            }
        });

        Ltime.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Ltime.setText("tiempo");

        LIcontime.setText("Vida");

        javax.swing.GroupLayout GameLayout = new javax.swing.GroupLayout(Game);
        Game.setLayout(GameLayout);
        GameLayout.setHorizontalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Lstatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBoard, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE))
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Bpause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GameLayout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Btower2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btower1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Btower3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(GameLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(GameLayout.createSequentialGroup()
                                        .addComponent(Ltime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(LIcontime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(GameLayout.createSequentialGroup()
                                            .addComponent(Llife, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(LIconlife, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GameLayout.createSequentialGroup()
                                            .addComponent(Lgold, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(LIcongold, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap(43, Short.MAX_VALUE))))
        );
        GameLayout.setVerticalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addComponent(Bpause, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btower1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btower2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btower3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lgold, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LIcongold, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Llife, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LIconlife, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ltime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LIcontime, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109))
            .addGroup(GameLayout.createSequentialGroup()
                .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lstatus)
                .addGap(0, 54, Short.MAX_VALUE))
        );

        Pause.setBackground(new java.awt.Color(153, 255, 153));
        Pause.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Pause.setFocusCycleRoot(true);
        Pause.setMaximumSize(new java.awt.Dimension(210, 320));
        Pause.setMinimumSize(new java.awt.Dimension(210, 320));

        Lpause.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Lpause.setText("Pausa");

        Bresume.setBackground(new java.awt.Color(153, 255, 204));
        Bresume.setText("Resumir");
        Bresume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresumeActionPerformed(evt);
            }
        });

        Bnew.setBackground(new java.awt.Color(153, 255, 204));
        Bnew.setText("Nuevo Juego");
        Bnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnewActionPerformed(evt);
            }
        });

        Bexit.setBackground(new java.awt.Color(153, 255, 204));
        Bexit.setText("Salir");
        Bexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PauseLayout = new javax.swing.GroupLayout(Pause);
        Pause.setLayout(PauseLayout);
        PauseLayout.setHorizontalGroup(
            PauseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PauseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PauseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Bresume, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bnew, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(Bexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PauseLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Lpause, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        PauseLayout.setVerticalGroup(
            PauseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PauseLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Lpause, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Bresume, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bnew, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bexit, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Game, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Pause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Game, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Pause, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bmenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bmenu1ActionPerformed
       select=1;
       Menu.setVisible(false);
       Game.setVisible(true);
       think=false;
       repaint();
    }//GEN-LAST:event_Bmenu1ActionPerformed

    private void Bmenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bmenu2ActionPerformed
        select=2;
        think=false;
    }//GEN-LAST:event_Bmenu2ActionPerformed

    private void Bmenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bmenu3ActionPerformed
     select=3;
     think=false;
    }//GEN-LAST:event_Bmenu3ActionPerformed

    private void Bmenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bmenu4ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_Bmenu4ActionPerformed

    private void BresumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresumeActionPerformed
        think=false;
        Pause.setVisible(false);
        Game.setVisible(true);
    }//GEN-LAST:event_BresumeActionPerformed

    private void BnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnewActionPerformed
     Lpause.setText("Pausa");
      Pause.setVisible(false);
      Game.setVisible(false);
      select=7;
      think=false;
    }//GEN-LAST:event_BnewActionPerformed

    private void BexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BexitActionPerformed

    private void BpauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BpauseActionPerformed
        think=true;
        Game.setVisible(false);
        Pause.setVisible(true);
    }//GEN-LAST:event_BpauseActionPerformed

    private void Btower1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btower1MouseClicked
 select=2;
    type=1;
    }//GEN-LAST:event_Btower1MouseClicked

    private void panelBoardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBoardMouseClicked
      x=evt.getX()/64;y=evt.getY()/64;
      think=false;
    }//GEN-LAST:event_panelBoardMouseClicked

    private void Btower3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btower3ActionPerformed
     select=3;
     
    }//GEN-LAST:event_Btower3ActionPerformed

    private void Btower2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Btower2MouseClicked
    select=2;  
    type=2;  
    }//GEN-LAST:event_Btower2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bexit;
    private javax.swing.JButton Bmenu1;
    private javax.swing.JButton Bmenu2;
    private javax.swing.JButton Bmenu3;
    private javax.swing.JButton Bmenu4;
    private javax.swing.JButton Bnew;
    private javax.swing.JButton Bpause;
    private javax.swing.JButton Bresume;
    private javax.swing.JButton Btower1;
    private javax.swing.JButton Btower2;
    private javax.swing.JButton Btower3;
    private javax.swing.JPanel Game;
    private javax.swing.JLabel LIcongold;
    private javax.swing.JLabel LIconlife;
    private javax.swing.JLabel LIcontime;
    private javax.swing.JLabel Lgold;
    private javax.swing.JLabel Llife;
    private javax.swing.JLabel Lpause;
    private javax.swing.JLabel Lstatus;
    private javax.swing.JLabel Ltime;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Pause;
    private javax.swing.JPanel panelBoard;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
