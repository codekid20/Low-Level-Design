import board.Board;
import game.Game;
import model.Symbol;
import player.Player;
import strategy.LineWinningStrategy;
import strategy.WinningStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(3);
        WinningStrategy winningStrategy = new LineWinningStrategy();

        Player p1 = new Player("Alice", Symbol.X);
        Player p2 = new Player("Bob", Symbol.O);

        Game game = new Game(board, List.of(p1, p2), winningStrategy);
        game.play();
    }
}