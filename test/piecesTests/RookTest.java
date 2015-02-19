package piecesTests;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.Piece;
import pieces.Queen;
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
        rook.move(new Position(4, 7));
    }

    @Test
    public void moveRook1() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(4,7));
        assertTrue(board.isAnyPieceAt(new Position(4, 7)));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
    }

    @Test
    public void moveRook2() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(4,0));
        assertTrue(board.isAnyPieceAt(new Position(4, 0)));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
    }

    @Test
    public void moveRook3() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(0,4));
        assertTrue(board.isAnyPieceAt(new Position(0, 4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
    }

    @Test
    public void moveRook4() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(7,4));
        assertTrue(board.isAnyPieceAt(new Position(7, 4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook5() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(4,6), board);
        rook.move(new Position(4, 7));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook6() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(4,1), board);
        rook.move(new Position(4, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook7() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(1,4), board);
        rook.move(new Position(0, 4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook8() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(6,4), board);
        rook.move(new Position(7, 4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook9() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(7,4), board);
        rook.move(new Position(7, 4));
    }

    @Test
    public void moveRook10() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        new Queen(Team.BLACK, new Position(7,4), board);
        rook.move(new Position(7, 4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook11() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(0, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook12() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(0, 7));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook13() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(7, 7));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveRook14() throws OutOfBoardException, InvalidMovimentException {
        rook = new Rook(Team.WHITE, new Position(4,4), board);
        rook.move(new Position(7, 0));
    }
}
