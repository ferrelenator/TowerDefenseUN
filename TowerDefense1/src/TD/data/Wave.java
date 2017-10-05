package TD.data;

import TD.ui.UI;
import java.util.ArrayList;


public class Wave {
    
    private int numberOfEnemies;
    private int numberOfWave;
    private Enemy enemy;
    private ArrayList<Enemy> enemyList;
    private int spawnTime;
    private int lastSpawn;
    private Board board;
    int i=0;

    public Wave(int spawnTime, Enemy enemy,Board board) {
      this.lastSpawn=0; 
     this.board=board;
     this.enemy=enemy;
    this.spawnTime=spawnTime;
    enemyList= new ArrayList<Enemy>();
    }
    
    public void update (){
        
        lastSpawn= i;
        if(lastSpawn > spawnTime){
            spawn();
         lastSpawn=0;   
        }
        i++;
        for(Enemy enemy:enemyList){
            switch(i){
            case 45:
            for (int a = (int)enemy.getY() ; a < 4; a++){
            enemy.update(enemy.getX(),a,board);
            }break;
            case 2:
            for (int a = (int)enemy.getX() ; a < 7; a++){
            enemy.update(a,enemy.getY(),board);
            }break;
            case 3:
            for (int a = (int)enemy.getY() ; a < 9; a++){
            enemy.update(enemy.getX(),a,board);
            }break;
            }  
        }
        
        
    }
    


    private void spawn() {
        enemyList.add(new Enemy(enemy.getX(),enemy.getY(),enemy.getSpeed()));
    }
}
