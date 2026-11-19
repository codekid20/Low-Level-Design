package strategy;

import board.Board;
import enums.Disc;
import models.Cell;

public interface WinningStrategy {
    boolean checkWinner(Board board, Cell lastMove, Disc disc);
}
