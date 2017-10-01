
package TD.data;

public class Board{
    
    private Square[][] board;

    
    public Board() {
        
   
        board = new Square[10][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                Square square = new Square(row, col,'X');
                board[row][col] = square;
            }
        }
        

    }
    
    public Board(int[][] newMap){
    
                 board = new Square[10][10];
                 char value=' ';

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                switch(newMap[i][j]){
                    case 0:
                value='X';
                break;
                    case 1:
                value=' ';
                break;
                case 2:
                value='O';
                break;
                case 3:
                value='#';
                break;
                }
                Square square = new Square(i, j,value);
                board[i][j] = square;
            }
        }
    }
    
 
    
    public void paint(float row,float col,char value){
                Square square = new Square(row, col,value);
                board[(int)row][(int)col] = square;
        
    }

    public Square[][] getBoard() {
        return board;
    }

    public void updateSquare(Square square) {
        board[(int) square.getRow()][(int) square.getCol()] = square;
    }

@Override
    public String toString() {
        String printBoard = "\n";

        for (int row = 0; row < board.length; row++) {
            printBoard = printBoard.concat("\t");
            for (int col = 0; col < board.length; col++) {
                printBoard = printBoard.concat(
                        String.valueOf(board[row][col]).concat(" "));
            }
            printBoard = printBoard.concat("\n");
        }
        return printBoard;
    }
    
}

