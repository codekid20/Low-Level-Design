package game;

import board.Board;
import player.Player;
import strategy.WinningStrategy;
import java.util.List;
import model.Cell;
public class Game {
    private final Board board;
    private final List<Player> players;
    private final WinningStrategy winningStrategy;
    private int currentPlayerIndex = 0;
    private boolean isOver = false;

    public Game(Board board, List<Player> players, WinningStrategy winningStrategy){
        this.board = board;
        this.players = players;
        this.winningStrategy = winningStrategy;
    }

    public void play(){
        while(!isOver){
            Player current = players.get(currentPlayerIndex);
            Cell cell = current.makeMove(board);

            if(!isValidCell(cell) || !board.isCellEmpty(cell.getRow(), cell.getCol())){
                System.out.println("Invalid move, try again.");
                continue;
            }

            board.placeSymbol(cell.getRow(), cell.getCol(), current.getSymbol());
            board.print();

            if(winningStrategy.checkWinner(board, cell, current.getSymbol())){
                System.out.println(current.getName() + " wins!");
                isOver = true;
                return;
            }

            if(board.isFull()){
                System.out.println("It's a draw!");
                isOver = true;
                return;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }

    private boolean isValidCell(Cell c) {
        int n = board.getSize();
        return c.getRow() >= 0 && c.getRow() < n && c.getCol() >= 0 && c.getCol() < n;
    }
}
