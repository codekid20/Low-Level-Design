package board;

import enums.Disc;
import models.Cell;

import java.util.Arrays;

public class Board {
    private final int rows;
    private final int cols;
    private final Disc[][] grid;
    private final int[] nextOpenRow;
    private int filledCells = 0;

    public Board(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Disc[rows][cols];
        for (Disc[] row : grid) Arrays.fill(row, Disc.EMPTY);
        this.nextOpenRow = new int[cols];
        Arrays.fill(nextOpenRow, rows - 1); // row 0 = top, row (rows - 1) = bottom
    }

    public boolean isColumnFull(int col) { return nextOpenRow[col] < 0; }

    public Cell dropDisc(int col, Disc disc) {
        if(isColumnFull(col)) throw new IllegalArgumentException("Column Full");
        int row = nextOpenRow[col];
        grid[row][col] = disc;
        nextOpenRow[col]--;
        filledCells++;
        return new Cell(row, col);
    }

    public boolean isFull() { return filledCells == rows * cols; }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    public Disc getDiscAt(int row, int col) {
        return grid[row][col];
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public void print() {
        for (int r = 0; r < rows; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < cols; c++) {
                Disc d = grid[r][c];
                sb.append(d == Disc.EMPTY ? "." : d == Disc.RED ? "R" : "Y").append(" ");
            }

            System.out.println(sb);
        }
    }
}
