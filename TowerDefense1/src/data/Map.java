/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Fenryr
 */
public class Map {
    private int[][] map;
    private int size;
    public Map(){
        size=10;
     map= new int[size][size];
     map= new int[][]{
                  {1,1,1,1,1,1,1,1,1,1},
                  {1,1,1,1,1,1,1,1,1,1},
                  {3,3,3,3,9,1,1,1,1,1},
                  {5,5,5,8,4,1,1,1,1,1},
                  {1,1,1,6,4,1,1,1,1,1},
                  {1,1,1,6,7,3,3,3,3,3},
                  {1,1,1,10,5,5,5,5,5,5},
                  {1,1,1,1,1,1,1,1,1,1},
                  {1,1,1,1,1,1,1,1,1,1},
                  {1,1,1,1,1,1,1,1,1,1}
                  };
         
    }
    public int[][] getMap() {
        return map;
    }
    public void setMap(int[][] map) {
        this.map = map;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    
    
    
    
}
