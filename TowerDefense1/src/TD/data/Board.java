
package TD.data;

public class Board{
    
    private Square[][] board;

    
    public Board() {

         
        char value = 'x';
        board = new Square[10][10];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                Square square = new Square(row, col,value);
                board[row][col] = square;
            }
        }
        

    }
    
    
    public void road(){
         
        for (int row = 2; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                Square square = new Square(row, col,'-');
                board[row][col] = square;
            }
        }
        
        for (int row = 4; row < 8; row++) {
            for (int col = 3; col < 5; col++) {
                Square square = new Square(row, col,'-');
                board[row][col] = square;
            }
        }
           
        for (int row = 6; row <8 ; row++) {
            for (int col = 5; col < 10; col++) {
                Square square = new Square(row, col,'-');
               board[row][col] = square;
            }
        }  
    }
    
    public void paint(int row,int col,char value){
                Square square = new Square(row, col,value);
                board[row][col] = square;
        
    }

    public Square[][] getBoard() {
        return board;
    }

    public void updateSquare(Square square) {
        board[square.getRow()][square.getCol()] = square;
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

