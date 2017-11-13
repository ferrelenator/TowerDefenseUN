/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import data.Board;
import data.Enemy;
import data.Player;
import data.Tower;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Fenryr
 */
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import ui.UISwing.GameBoard;
public class UISwing extends JFrame implements UI {
    
    private GameBoard myBoard;
    private Board board;
    private Player player;
    private int select;
    private boolean charge=false;
    /**
     * Creates new form UISwing3
     */
    public UISwing() {
        initComponents();
        //Dimmension(832,640);
        Menu.setVisible(true);
        Game.setVisible(false);
        Pause.setVisible(false);
        this.pack();
        this.setVisible(true);
      
    }

    class GameBoard extends JPanel implements Runnable{
        
        
        private int timeLimit=2;
        
        public Thread thread= new Thread(this);
        Dimension size=new Dimension(640,640);
        
        public GameBoard(){
        setPreferredSize(size);
          for (int row = 0; row < board.getBoard().length; row++) {
                for (int col = 0; col < board.getBoard().length; col++) {
                 board.getBoard()[row][col].init(row, col);
            }}
        
        }
        
        public void reinit(){
        board.getTowerList().forEach((t) -> {
            t.getSquare().init(t.getRow(), t.getCol());
        });
        board.getEnemyList().forEach((e) -> {
         e.getSquare().init(e.getRow(),e.getCol());
        }); 
        }
        
        public void stop() {
        timeLimit=-1;
        }
        public void resume(){
        timeLimit=2;
        }
        @Override
        public void run() {
            while(timeLimit>1){
                try {
                    reinit();
                    repaint();
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UISwing.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    public synchronized int printTitle() {
         select = -1;
          while (select  == -1) {
            pause();
        }
       return select;
    }

    @Override
    public void instructions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void credits() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int printMenu() {
       return 1;
    }

    @Override
    public String playerName() {
        return "Player";
    }

    @Override
    public void charge(Board board, Player player, int second) {
        
    }

    @Override
    public int[] placeTower() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moneyEnemy(Enemy enemy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moneyTower(Tower tower) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int selectTower(Board board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void moneyTower(Tower tower, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
        }

    @Override
    public void win(int i) {
        }

    @Override
    public void printBoard(Board board) {
        this.board=board;    
        charge =true;
        myBoard=new GameBoard();
        panelBoard.add(myBoard);
        this.revalidate();
        this.repaint();
        myBoard.setVisible(true);
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
        Lgold = new javax.swing.JLabel();
        Llife = new javax.swing.JLabel();
        Linfo = new javax.swing.JLabel();
        Bwave = new javax.swing.JButton();
        Bnext = new javax.swing.JButton();
        Btower1 = new javax.swing.JButton();
        Btower2 = new javax.swing.JButton();
        Btower3 = new javax.swing.JButton();
        Bpause = new javax.swing.JButton();
        panelBoard = new javax.swing.JPanel();
        Pause = new javax.swing.JPanel();
        Lpause = new javax.swing.JLabel();
        Bresume = new javax.swing.JButton();
        Bnew = new javax.swing.JButton();
        Bexit = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Tempus Sans ITC", 0, 54)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Tower Defense");

        Bmenu1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Bmenu1.setText("Nuevo Juego");
        Bmenu1.setToolTipText("");
        Bmenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bmenu1ActionPerformed(evt);
            }
        });

        Bmenu2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Bmenu2.setText("Instrucciones");
        Bmenu2.setToolTipText("");
        Bmenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bmenu2ActionPerformed(evt);
            }
        });

        Bmenu3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 24)); // NOI18N
        Bmenu3.setText("Creditos");
        Bmenu3.setToolTipText("");
        Bmenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bmenu3ActionPerformed(evt);
            }
        });

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
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Bmenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bmenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bmenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bmenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bmenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bmenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bmenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bmenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        Game.setBackground(new java.awt.Color(153, 255, 153));

        Lgold.setText("Oro");

        Llife.setText("Vida");

        Linfo.setText("Proximos enemigos");

        Bwave.setText("oleada");
        Bwave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BwaveActionPerformed(evt);
            }
        });

        Bnext.setText("siguiente");
        Bnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnextActionPerformed(evt);
            }
        });

        Btower1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/towerDefense_tile206.png"))); // NOI18N
        Btower1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btower1ActionPerformed(evt);
            }
        });

        Btower2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/towerDefense_tile249.png"))); // NOI18N
        Btower2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btower2ActionPerformed(evt);
            }
        });

        Btower3.setText("torre3");
        Btower3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btower3ActionPerformed(evt);
            }
        });

        Bpause.setText("Pausa");
        Bpause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BpauseActionPerformed(evt);
            }
        });

        panelBoard.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout GameLayout = new javax.swing.GroupLayout(Game);
        Game.setLayout(GameLayout);
        GameLayout.setHorizontalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Linfo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GameLayout.createSequentialGroup()
                                .addComponent(Bwave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Bnext, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Bpause, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Btower2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btower1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btower3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Lgold, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Llife, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        GameLayout.setVerticalGroup(
            GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GameLayout.createSequentialGroup()
                        .addGroup(GameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bwave, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Bnext, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btower1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btower2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Btower3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(Lgold, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Llife, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Linfo, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Bpause, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 15, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Lpause.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Lpause.setText("Pausa");

        Bresume.setText("Resumir");
        Bresume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BresumeActionPerformed(evt);
            }
        });

        Bnew.setText("Nuevo Juego");
        Bnew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BnewActionPerformed(evt);
            }
        });

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

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

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
    }//GEN-LAST:event_Bmenu1ActionPerformed

    private void Bmenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bmenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bmenu2ActionPerformed

    private void Bmenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bmenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bmenu3ActionPerformed

    private void Bmenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bmenu4ActionPerformed
    System.exit(0);
    }//GEN-LAST:event_Bmenu4ActionPerformed

    private void BresumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BresumeActionPerformed
        Pause.setVisible(false);
    }//GEN-LAST:event_BresumeActionPerformed

    private void BnewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnewActionPerformed
       Game.setVisible(false);
       Pause.setVisible(false);
       Menu.setVisible(true);
    }//GEN-LAST:event_BnewActionPerformed

    private void BexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BexitActionPerformed

    private void BpauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BpauseActionPerformed
        Pause.setVisible(true);
    }//GEN-LAST:event_BpauseActionPerformed

    private void Btower3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btower3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btower3ActionPerformed

    private void Btower2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btower2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btower2ActionPerformed

    private void Btower1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btower1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btower1ActionPerformed

    private void BnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BnextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BnextActionPerformed

    private void BwaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BwaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BwaveActionPerformed

    
    /**
     * @param args the command line arguments
     */
  /*  public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UISwing().setVisible(true);
            }
        });
    } 
*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bexit;
    private javax.swing.JButton Bmenu1;
    private javax.swing.JButton Bmenu2;
    private javax.swing.JButton Bmenu3;
    private javax.swing.JButton Bmenu4;
    private javax.swing.JButton Bnew;
    private javax.swing.JButton Bnext;
    private javax.swing.JButton Bpause;
    private javax.swing.JButton Bresume;
    private javax.swing.JButton Btower1;
    private javax.swing.JButton Btower2;
    private javax.swing.JButton Btower3;
    private javax.swing.JButton Bwave;
    private javax.swing.JPanel Game;
    private javax.swing.JLabel Lgold;
    private javax.swing.JLabel Linfo;
    private javax.swing.JLabel Llife;
    private javax.swing.JLabel Lpause;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Pause;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel panelBoard;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
