/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import ui.UISwing;

/**
 *
 * @author Fenryr
 */
public class Texture implements Serializable {
    
    private BufferedImage grass,road,road3,road4,road5,road6,road7,road8,enemy1,enemy2,rock,tower1,tower2,road9,road10;
    public  Texture(){
        try {                
            this.grass = ImageIO.read(new File("src/resources/towerDefense_tile024.png"));
            this.road = ImageIO.read(new File("src/resources/towerDefense_tile050.png"));
  
            
            this.road3 = ImageIO.read(new File("src/resources/towerDefense_tile047.png"));
            this.road4 = ImageIO.read(new File("src/resources/towerDefense_tile023.png"));
            this.road5 = ImageIO.read(new File("src/resources/towerDefense_tile001.png"));
            this.road6 = ImageIO.read(new File("src/resources/towerDefense_tile025.png"));
            this.road7 = ImageIO.read(new File("src/resources/towerDefense_tile046.png"));
            this.road8 = ImageIO.read(new File("src/resources/towerDefense_tile002.png"));
            this.road9 = ImageIO.read(new File("src/resources/towerDefense_tile004.png"));
            this.road10 = ImageIO.read(new File("src/resources/towerDefense_tile026.png"));
            
            this.rock = ImageIO.read(new File("src/resources/towerDefense_tile136.png"));
            this.tower1 = ImageIO.read(new File("src/resources/towerDefense_tile206.png"));
            this.tower2 = ImageIO.read(new File("src/resources/towerDefense_tile249.png"));
            this.enemy1 = ImageIO.read(new File("src/resources/towerDefense_tile245.png"));
            this.enemy2 = ImageIO.read(new File("src/resources/towerDefense_tile246.png"));
         } catch (IOException ex) {System.out.println("No cargo las imagenes correctamente");}
    }

    /**
     * @return the grass
     */
    public BufferedImage getGrass() {
        return grass;
    }

    /**
     * @param grass the grass to set
     */
    public void setGrass(BufferedImage grass) {
        this.grass = grass;
    }

    /**
     * @return the road
     */
    public BufferedImage getRoad() {
        return road;
    }

    /**
     * @param road the road to set
     */
    public void setRoad(BufferedImage road) {
        this.road = road;
    }

    /**
     * @return the road3
     */
    public BufferedImage getRoad3() {
        return road3;
    }

    /**
     * @param road3 the road3 to set
     */
    public void setRoad3(BufferedImage road3) {
        this.road3 = road3;
    }

    /**
     * @return the road4
     */
    public BufferedImage getRoad4() {
        return road4;
    }

    /**
     * @param road4 the road4 to set
     */
    public void setRoad4(BufferedImage road4) {
        this.road4 = road4;
    }

    /**
     * @return the road5
     */
    public BufferedImage getRoad5() {
        return road5;
    }

    /**
     * @param road5 the road5 to set
     */
    public void setRoad5(BufferedImage road5) {
        this.road5 = road5;
    }

    /**
     * @return the road6
     */
    public BufferedImage getRoad6() {
        return road6;
    }

    /**
     * @param road6 the road6 to set
     */
    public void setRoad6(BufferedImage road6) {
        this.road6 = road6;
    }

    /**
     * @return the road7
     */
    public BufferedImage getRoad7() {
        return road7;
    }

    /**
     * @param road7 the road7 to set
     */
    public void setRoad7(BufferedImage road7) {
        this.road7 = road7;
    }

    /**
     * @return the road8
     */
    public BufferedImage getRoad8() {
        return road8;
    }

    /**
     * @param road8 the road8 to set
     */
    public void setRoad8(BufferedImage road8) {
        this.road8 = road8;
    }

    /**
     * @return the enemy1
     */
    public BufferedImage getEnemy1() {
        return enemy1;
    }

    /**
     * @param enemy1 the enemy1 to set
     */
    public void setEnemy1(BufferedImage enemy1) {
        this.enemy1 = enemy1;
    }

    /**
     * @return the enemy2
     */
    public BufferedImage getEnemy2() {
        return enemy2;
    }

    /**
     * @param enemy2 the enemy2 to set
     */
    public void setEnemy2(BufferedImage enemy2) {
        this.enemy2 = enemy2;
    }

    /**
     * @return the rock
     */
    public BufferedImage getRock() {
        return rock;
    }

    /**
     * @param rock the rock to set
     */
    public void setRock(BufferedImage rock) {
        this.rock = rock;
    }

    /**
     * @return the tower1
     */
    public BufferedImage getTower1() {
        return tower1;
    }

    /**
     * @param tower1 the tower1 to set
     */
    public void setTower1(BufferedImage tower1) {
        this.tower1 = tower1;
    }

    /**
     * @return the tower2
     */
    public BufferedImage getTower2() {
        return tower2;
    }

    /**
     * @param tower2 the tower2 to set
     */
    public void setTower2(BufferedImage tower2) {
        this.tower2 = tower2;
    }

    /**
     * @return the road9
     */
    public BufferedImage getRoad9() {
        return road9;
    }

    /**
     * @param road9 the road9 to set
     */
    public void setRoad9(BufferedImage road9) {
        this.road9 = road9;
    }

    /**
     * @return the road10
     */
    public BufferedImage getRoad10() {
        return road10;
    }

    /**
     * @param road10 the road10 to set
     */
    public void setRoad10(BufferedImage road10) {
        this.road10 = road10;
    }

    
}
