package viewTests;

import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlay.Game;
import gamePlay.Player;
import org.junit.Test;
import view.ChessInterface;

/**
 * Created by Bruno on 2/19/2015.
 */
public class ChessInterfaceTests {

    @Test
    public void showTest1() throws OutOfBoardException {
        Game game = new Game(new Player(), new Player(), new Board());
        game.initializeBoard();
        ChessInterface chessInterface = new ChessInterface(game);
        chessInterface.main(null);
    }

}
