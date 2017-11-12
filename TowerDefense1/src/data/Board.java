package data;

import java.util.ArrayList;


public class Board{
    
    private Square[][] board;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Tower> towerList;

    public Board(){  
    
        enemyList= new ArrayList();
        towerList= new ArrayList();
    
        int[][] newMap = {
                  {0,0,0,0,0,2,2,2,2,2},
                  {0,0,0,0,0,0,2,2,2,2},
                  {1,1,1,1,0,3,0,2,2,2},
                  {1,1,1,1,0,3,3,0,2,2},
                  {0,0,1,1,0,3,3,3,0,2},
                  {0,0,1,1,0,0,0,0,0,0},
                  {0,0,1,1,1,1,1,1,1,1},
                  {0,0,1,1,1,1,1,1,1,1},
                  {0,0,0,0,0,0,0,0,0,0},
                  {2,2,2,2,2,2,0,0,0,0}
                  };
                
        board = new Square[newMap.length][newMap.length];
        char value='X';

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
    
    public void newEnemy1(int x,int y) {
        enemyList.add(new Enemy(x,y,'#',30,1,15,1));       
    }
    public void newEnemy2(int x,int y) {
        enemyList.add(new Enemy(x,y,'$',40,1,20,1));     
    }
    
    public void newTower1(Player player,int x,int y) {
        player.setMoney(player.getMoney()-100);
        towerList.add(new Tower(x,y,10,100,1));  
    }
    
    public void newTower2(Player player,int x,int y) {
        player.setMoney(player.getMoney()-150);
        towerList.add(new Tower(x,y,5,150,2));  
    }
    
    public void killEnemy(Player player,int i) {
        player.setMoney(player.getMoney()+ getEnemyList().get(i).getMoney());
        getEnemyList().remove(i);      
    }
    
    public void winEnemy(Player player,int i) {
        player.setLife(player.getLife()-getEnemyList().get(i).getDamage());
        getEnemyList().remove(i);      
    }
    
    public void removeTower(Player player,int i) {
        player.setMoney(player.getMoney()+ getTowerList().get(i).getSell());
        getTowerList().remove(i); 
    }

    public Square[][] getBoard() {
        return board;
    }
    public void setBoard(Square[][] board) {
        this.board=board;
    }
    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }
    public void setEnemyList(ArrayList<Enemy> enemyList) {
        this.enemyList = enemyList;
    }
    public void setTowerList(ArrayList<Tower> towerList) {
        this.towerList = towerList;
    }
    public ArrayList<Tower> getTowerList() {
        return towerList;
    }
}
