package TD.data;


public class Board{
    
    private Square[][] board;

    public Board(){  
    int[][] newMap = {
                  {0,0,0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,2,2,0},
                  {1,1,1,1,0,0,0,2,2,0},
                  {1,1,1,1,0,0,0,0,0,0},
                  {0,0,1,1,0,0,0,0,0,0},
                  {0,0,1,1,0,0,0,0,0,0},
                  {0,0,1,1,1,1,1,1,1,1},
                  {0,0,1,1,1,1,1,1,1,1},
                  {0,0,0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,0,0,0},
                  };
                
                board = new Square[newMap.length][newMap.length];
                 char value=' ';

        for (int i = 0; i < newMap.length; i++) {
            for (int j = 0; j < newMap.length; j++) {
                switch(newMap[i][j]){
                case 0:
                value='X';
                break;
                case 1:
                value=' ';
                break;
                case 2:
                value='W';
                break;
                }
                Square square = new Square(i, j,value);
                board[i][j]=square;
            }
        }
    }

    public Square[][] getBoard() {
        return board;
    }
}

    /*
    public Board() {
        board = new Square[10][10];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                Square square = new Square(row, col,'X');
                board[row][col] = square;
            }
        }
        

    }
    */
