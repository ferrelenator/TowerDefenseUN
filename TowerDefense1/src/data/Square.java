package data;

public class Square {
    
    private int row,col;
    private char value;

    public Square(int row,int col, char value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    public int[] test(){
        int[] i={row,col};
        return i;
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
}
