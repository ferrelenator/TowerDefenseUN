package TD.data;


import TD.ui.UI;
import java.util.ArrayList;


public class Array {
    
    private ArrayList<Enemy> enemyList;
    private ArrayList<Tower> towerList;

    public Array() {
    enemyList= new ArrayList();
    towerList= new ArrayList();
    }
    public void spawn(int time){
       
    if(time%4 ==0){ 
    newEnemy(2,0);   
    }
    }
    public void newEnemy(int x,int y) {
        enemyList.add(new Enemy(x,y,'#',1));       
    }
    public void moveEnemy() {
        for(Enemy e : enemyList) {
            
            if(8 <  (e.getRow() + e.getCol()) && (e.getRow() + e.getCol()) < 15 ){
            e.setCol(e.getCol()+1);
            System.out.println(e.getRow()+ "-"+e.getCol());}
            
            if(4 < (e.getRow() + e.getCol()) && (e.getRow() + e.getCol()) < 9  ){
            e.setRow(e.getRow()+1);
            System.out.println(e.getRow()+ "-"+e.getCol());}
            
            if((e.getRow()+e.getCol()) <5 ){
            e.setCol(e.getCol()+1);
                System.out.println(e.getRow()+ "-"+e.getCol());}
           
        }  
    }    
    
    public void newTower() {
        UI.towers();
        towerList.add(new Tower(UI.menuDevelop(),UI.menuDevelop(),'O'));
    }


    /**
     * @return the enemyList
     */
    public ArrayList<Enemy> getEnemyList() {
        return enemyList;
    }

    /**
     * @param enemyList the enemyList to set
     */
    public void setEnemyList(ArrayList<Enemy> enemyList) {
        this.enemyList = enemyList;
    }

    /**
     * @param towerList the towerList to set
     */
    public void setTowerList(ArrayList<Tower> towerList) {
        this.towerList = towerList;
    }

    /**
     * @return the towerList
     */
    public ArrayList<Tower> getTowerList() {
        return towerList;
    }

    
}
