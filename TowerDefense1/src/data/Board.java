package data;

import java.util.ArrayList;


public class Board{
    
    private Square[][] board;
    private ArrayList<Enemy> enemyList;
    private ArrayList<Tower> towerList;

    public Board(){  
    
        enemyList= new ArrayList<>();
        towerList= new ArrayList<>();
        board=new Board[][];
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
