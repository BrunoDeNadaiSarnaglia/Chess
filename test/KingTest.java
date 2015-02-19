import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.King;
import pieces.Piece;
import pieces.Queen;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bruno on 2/18/2015.
 */
public class KingTest {



    private Board board;
    private Piece king;
    private Piece queen;

    @Before
    public void settingTest(){
        board = new Board();
    }


    @Test(expected = InvalidMovimentException.class)
    public void moveKing() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(7,6));

    }

    @Test
    public void moveKing2() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(4,4));
        assertTrue(board.isAnyPieceAt(new Position(4,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void testIfIsKing() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        queen = new Queen(Team.WHITE, new Position(4,5), board);
        assertTrue(king.isKing());
        assertFalse(queen.isKing());
    }
}
