package player;

import board.Board;
import model.Cell;
import model.Symbol;

import java.util.Scanner;

public class Player {
    private final String name;
    private final Symbol symbol;
    private final Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol){
        this.name = name;
        this.symbol = symbol;
    }

    public Cell makeMove(Board board){

        System.out.println(name + " (" + symbol + "), enter row and col:");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Cell(row, col);
    }

    public String getName() { return name; }
    public Symbol getSymbol() { return symbol; }
}
