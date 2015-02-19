package piecesTests;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.Piece;
import pieces.Rook;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bruno on 2/18/2015.
 */
public class RookTest {

    private Board board;
    public Piece rook;

    
    @Before
    public void settingTest(){
        board = new Board();
    }


    @Test
    public void moveRook() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(4,6));
        assertTrue(board.isAnyPieceAt(new Position(4, 6)));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRookWrongPath() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(5, 6));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRookToTeamMatePosition() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        new Rook(Team.WHITE, new Position(4,7), board);
        rook.move(new Position(4,7));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRookSomeoneInPath() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,1), board);
        new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(4,7));
        assertFalse(board.isAnyPieceAt(new Position(4,7)));
        assertTrue(board.isAnyPieceAt(new Position(4, 1)));
    }
}
