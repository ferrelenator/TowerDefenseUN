/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import business.Rule;
import business.Turn;
import data.Board;
import data.Enemy;
import data.Player;
import data.Tower;

/**
 *
 * @author Fenryr
 */
public interface UI {
    public int printTitle() ;
    public void instructions();
    public void credits();
    public int printMenu();   
    public String playerName();
    public void charge(Board board,Player player, int second);
    public int[] placeTower();
    public void moneyEnemy(Enemy enemy);
    public void moneyTower(Tower tower);
    public int selectTower(Board board);
    public void moneyTower(Tower tower, int i);
    public void infoTime(int i);
    public void infoPlayer(Player player);
    public void infoEnemy(Board board);
    public void infoTower(Board board);
    public void error(int i);
    public void win(int i);
    public void printBoard(Board board);

    public void newGame(Board board, Player player, Rule rule, Turn turn);
}
