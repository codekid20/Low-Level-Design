package game;

import board.Board;
import models.Cell;
import player.Player;
import strategy.WinningStrategy;

import java.util.List;

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

    public void play() {
        while (!isOver) {

            Player current = players.get(currentPlayerIndex);
            int col = current.choosenColumn(board);

            if(col < 0 || col >= board.getCols() || board.isColumnFull(col)) {
                System.out.println("Invalid column, try again.");
                continue; // don't advance turn
            }

            Cell dropped = board.dropDisc(col, current.getDisc());
            board.print();

            if(winningStrategy.checkWinner(board, dropped, current.getDisc())) {
                System.out.println(current.getName() + " wins!");
                isOver = true;
                return;
            }

            if(board.isFull()) {
                System.out.println("It's a draw!");
                isOver = true;
                return;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
    }
}
