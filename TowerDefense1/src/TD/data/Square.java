package TD.data;

public class Square {
    
    private float row;
    private float col;
    private char value;

    public Square(float row, float col, char value) {
        this.row = row;
        this.col = row;
        this.value = value;
    }
    



    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    public float getRow() {
        return row;
    }


    public void setRow(float row) {
        this.row = row;
    }


    public float getCol() {
        return col;
    }

    public void setCol(float col) {
        this.col = col;
    }
    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}
