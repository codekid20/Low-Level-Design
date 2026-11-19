package board;

import model.Symbol;

import java.util.Arrays;

public class Board {

    private final int size;
    private final Symbol[][] grid;
    private int filledCells = 0;

    public Board(int size){
        this.size = size;
        this.grid = new Symbol[size][size];
        for (Symbol[] row : grid) Arrays.fill(row, Symbol.EMPTY);
    }

    public boolean isCellEmpty(int row, int col){
        return grid[row][col] == Symbol.EMPTY;
    }

    public void placeSymbol(int row, int col, Symbol symbol){
        grid[row][col] = symbol;
        filledCells++;
    }

    public boolean isFull() { return filledCells == size * size; }
    public int getSize() { return size; }
    public Symbol getSymbolAt(int row, int col) { return grid[row][col]; }

    public void print() {

        for (int r = 0; r < size; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < size; c++) {
                sb.append(grid[r][c] == Symbol.EMPTY ? "-": grid[r][c]).append(" ");
            }

            System.out.println(sb);
        }
    }
}
