package data;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
public class Square extends Rectangle{
    
    private int row,col;
    private char value;
    private BufferedImage  texture;
    public Square(int row,int col,char value,BufferedImage texture) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.texture=texture;
        this.x=col*64;
        this.y=row*64;
        this.width=64;
        this.height=64;
        this.setBounds(col*64,row*64, width,height);
    }
    
    public void draw(Graphics g,ImageObserver io){
        g.drawImage(texture, x,y, io);
    }
    
    
    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public char getValue() {
        return value;
    }
    public void setValue(char value) {
        this.value = value;
    }
    public BufferedImage getTexture() {
        return texture;
    }
    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }
}
