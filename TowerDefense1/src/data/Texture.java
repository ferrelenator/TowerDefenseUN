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
    
    private BufferedImage grass,road,road1,road2,road3,road4,road5,road6,road7,road8,enemy,rock,tower;
    public Texture(){
        try {                
            this.grass = ImageIO.read(new File("src/resources/towerDefense_tile024.png"));
            this.road1 = ImageIO.read(new File("src/resources/towerDefense_tile001.png"));
            this.road2 = ImageIO.read(new File("src/resources/towerDefense_tile050.png"));
            this.road3 = ImageIO.read(new File("src/resources/towerDefense_tile047.png"));
            this.road4 = ImageIO.read(new File("src/resources/towerDefense_tile023.png"));
            this.road5 = ImageIO.read(new File("src/resources/towerDefense_tile001.png"));
            this.road6 = ImageIO.read(new File("src/resources/towerDefense_tile025.png"));
            this.road7 = ImageIO.read(new File("src/resources/towerDefense_tile046.png"));
            this.road8 = ImageIO.read(new File("src/resources/towerDefense_tile002.png"));
            this.rock = ImageIO.read(new File("src/resources/towerDefense_tile136.png"));
            this.tower = ImageIO.read(new File("src/resources/towerDefense_tile206.png"));
            this.enemy = ImageIO.read(new File("src/resources/towerDefense_tile245.png"));
         } catch (IOException ex) {System.out.println("No cargo las imagenes correctamente");}
    }

    public BufferedImage getGrass1() {
        return getGrass();
    }
    public void setGrass1(BufferedImage grass) {
        this.setGrass(grass);
    }
    public BufferedImage getRoad() {
        return road;
    }
    public void setRoad(BufferedImage road) {
        this.road = road;
    }
    public BufferedImage getEnemy() {
        return enemy;
    }
    public void setEnemy(BufferedImage enemy) {
        this.enemy = enemy;
    }
    public BufferedImage getRock() {
        return rock;
    }
    public void setRock(BufferedImage rock) {
        this.rock = rock;
    }
    public BufferedImage getTower() {
        return tower;
    }
    public void setTower(BufferedImage tower) {
        this.tower = tower;
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
     * @return the road1
     */
    public BufferedImage getRoad1() {
        return road1;
    }

    /**
     * @param road1 the road1 to set
     */
    public void setRoad1(BufferedImage road1) {
        this.road1 = road1;
    }

    /**
     * @return the road2
     */
    public BufferedImage getRoad2() {
        return road2;
    }

    /**
     * @param road2 the road2 to set
     */
    public void setRoad2(BufferedImage road2) {
        this.road2 = road2;
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
}
