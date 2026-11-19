package strategy;

import board.Board;
import model.Cell;
import model.Symbol;

public class LineWinningStrategy implements WinningStrategy{

    @Override
    public boolean checkWinner(Board board, Cell lastMove, Symbol symbol){

        int n = board.getSize();
        int row = lastMove.getRow();
        int col = lastMove.getCol();

        return checkRow(board, row, symbol) || checkCol(board, col, symbol) || (row == col && checkDiagonal(board, symbol))
                || (row + col == n - 1 && checkAntiDiagonal(board, symbol));
    }

    private boolean checkRow(Board board, int row, Symbol symbol){

        for (int c = 0; c < board.getSize(); c++) {
            if(board.getSymbolAt(row, c) != symbol) return false;
        }
        return true;
    }

    private boolean checkCol(Board board, int col, Symbol symbol){

        for (int r = 0; r < board.getSize(); r++) {
            if(board.getSymbolAt(r, col) != symbol) return false;
        }

        return true;
    }

    private boolean checkDiagonal(Board board, Symbol symbol){

        for (int i = 0; i < board.getSize(); i++) {
            if(board.getSymbolAt(i, i) != symbol) return false;
        }
        
        return true;
    }
    
    private boolean checkAntiDiagonal(Board board, Symbol symbol){
        int n = board.getSize();
        for (int i = 0; i < n; i++) {
            if(board.getSymbolAt(i, n-1-i) != symbol) return false;
        }

        return true;
    }
}
