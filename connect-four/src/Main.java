import board.Board;
import enums.Disc;
import game.Game;
import player.Player;
import strategy.ConnectFourWinningStrategy;
import strategy.WinningStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(6, 7);
        WinningStrategy winningStrategy = new ConnectFourWinningStrategy();

        Player p1 = new Player("Alice", Disc.RED);
        Player p2 = new Player("Bob", Disc.YELLOW);

        Game game = new Game(board, List.of(p1, p2), winningStrategy);
        game.play();
    }
}