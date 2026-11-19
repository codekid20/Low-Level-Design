package strategy;

import board.Board;
import model.Cell;
import model.Symbol;

public interface WinningStrategy {

    boolean checkWinner(Board board, Cell lastMove, Symbol symbol);
}
