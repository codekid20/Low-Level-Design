package player;

import board.Board;
import enums.Disc;

import java.util.Scanner;

public class Player {

    private final String name;
    private final Disc disc;
    private final Scanner scanner = new Scanner(System.in);

    public Player(String name, Disc disc) {
        this.name = name;
        this.disc = disc;
    }

    public int choosenColumn(Board board) {
        System.out.println(name + " (" + disc + "), choose a column:");
        return scanner.nextInt();
    }

    public String getName() { return name; }
    public Disc getDisc() { return disc; }
}
