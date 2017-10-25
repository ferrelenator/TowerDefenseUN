/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TD.business;

import TD.data.*;

/**
 *
 * @author Fenryr
 */
public class Artist {
    private String printBoard;  
    private char[][] value;
    
    public Artist(){
        
    }



    public String paint(Board board){
        printBoard= "\n";
        value= new char[ board.getBoard().length][ board.getBoard().length];   
        
        for (int row = 0; row < board.getBoard().length; row++) {
            for (int col = 0; col < board.getBoard().length; col++) {
                value[row][col]=board.getBoard()[row][col].getValue();
            }
        }
        board.getTowerList().forEach((t) -> {
            value[t.getRow()][t.getCol()]= t.getValue();
        });
        board.getEnemyList().forEach((e) -> {
            value[e.getRow()][e.getCol()]=e.getValue();
        });    
        for (int row = 0; row < board.getBoard().length; row++) {
            printBoard=printBoard.concat("\t");
                for (int col = 0; col < board.getBoard().length; col++) {
                    printBoard = printBoard.concat(String.valueOf(value[row][col])).concat(" ");
                }
            printBoard = printBoard.concat("\n");
        }
        return printBoard;
    }
    public String getPrintBoard() {
        return printBoard;
    }
    public void setPrintBoard(String printBoard) {
        this.printBoard = printBoard;
    }
}
