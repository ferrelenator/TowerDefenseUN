package TD.data;

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

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * @return the col
     */
    public int getCol() {
        return col;
    }

    /**
     * @param col the col to set
     */
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * @return the value
     */
    public char getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(char value) {
        this.value = value;
    }


}
