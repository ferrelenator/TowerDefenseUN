package data;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public class Square extends Rectangle{
    
    private int row,col;
    private char value;
    private BufferedImage  texture;
    public Square(int row,int col,char value,BufferedImage texture) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.texture=texture;
        this.width=64;
        this.height=64;
        this.x=col;
        this.y=row;
        this.setBounds(x, y, width,height);
    }
    
    
    public void draw(Graphics g){
        g.drawRect(x, y, width,height);
    //    g.drawImage(getTexture(), x, y, this);
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
    
   

    /**
     * @return the texture
     */
    public BufferedImage getTexture() {
        return texture;
    }

    /**
     * @param texture the texture to set
     */
    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    
    
    
}
