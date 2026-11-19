package strategy;

import board.Board;
import enums.Disc;
import models.Cell;

public class ConnectFourWinningStrategy implements WinningStrategy {

    private static final int WIN_LENGTH = 4;

    private static final int[][] DIRECTIONS = {
            {0, 1}, // horizontal
            {1, 0}, // vertical
            {1, 1}, // diagonal down right
            {1, -1} // diagonal down left;
    };

    @Override
    public boolean checkWinner(Board board, Cell lastMove, Disc disc) {
        for(int[] dir : DIRECTIONS) {
            int count = 1;
            count += countInDirection(board, lastMove, disc, dir[0], dir[1]);
            count += countInDirection(board, lastMove, disc, -dir[0], -dir[1]);
            if(count >= WIN_LENGTH) return true;
        }

        return false;
    }

    private int countInDirection(Board board, Cell start, Disc disc, int dRow, int dCol) {

        int count = 0;
        int row = start.getRow() + dRow;
        int col = start.getCol() + dCol;

        while (board.isInBounds(row, col) && board.getDiscAt(row, col) == disc) {
            count++;
            row += dRow;
            col += dCol;
        }

        return count;
    }
}
