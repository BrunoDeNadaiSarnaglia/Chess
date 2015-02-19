package piecesTests;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.Bishop;
import pieces.Piece;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bruno on 2/18/2015.
 */
public class BishopTest {

    private Board board;
    public Piece bishop;

    @Before
    public void settingTest(){
        board = new Board();
    }

    @Test
    public void moveBishop() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,1), board);
        bishop.move(new Position(7,4));
        assertFalse(board.isAnyPieceAt(new Position(4,1)));
        assertTrue(board.isAnyPieceAt(new Position(7,4)));
    }

    @Test
    public void moveBishop2() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(7,1), board);
        bishop.move(new Position(4,4));
        assertFalse(board.isAnyPieceAt(new Position(4,1)));
        assertTrue(board.isAnyPieceAt(new Position(4,4)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishopSomeoneInPath() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,1), board);
        new Bishop(Team.WHITE, new Position(6,3), board);
        bishop.move(new Position(7,4));
        assertFalse(board.isAnyPieceAt(new Position(4, 1)));
        assertTrue(board.isAnyPieceAt(new Position(6, 3)));
        assertTrue(board.isAnyPieceAt(new Position(7,4)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishopSomeoneInPath2() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.WHITE, new Position(6,2), board);
        bishop.move(new Position(7, 1));
    }

    @Test
    public void moveBishopOpponentPlace() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,1), board);
        new Bishop(Team.BLACK, new Position(7,4), board);
        bishop.move(new Position(7,4));
        assertFalse(board.isAnyPieceAt(new Position(4,1)));
        assertTrue(board.isAnyPieceAt(new Position(7,4)));
    }

    @Test
    public void moveBishopOpponentPlace2() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.BLACK, new Position(7,1), board);
        bishop.move(new Position(7, 1));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(7,1)));
    }

    @Test
    public void moveBishop1() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.BLACK, new Position(7,7), board);
        bishop.move(new Position(6,6));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(6, 6)));
        assertTrue(board.isAnyPieceAt(new Position(7,7)));
    }

    @Test
    public void moveBishop3() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        bishop.move(new Position(6, 6));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(6, 6)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishop4() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        bishop.move(new Position(5,6));
        assertFalse(board.isAnyPieceAt(new Position(4,4)));
        assertTrue(board.isAnyPieceAt(new Position(6, 6)));
    }

    @Test
    public void moveBishop5() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        bishop.move(new Position(2,6));
        assertFalse(board.isAnyPieceAt(new Position(4,4)));
        assertTrue(board.isAnyPieceAt(new Position(2, 6)));
    }

    @Test
    public void moveBishop6() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        bishop.move(new Position(6,2));
        assertFalse(board.isAnyPieceAt(new Position(4,4)));
        assertTrue(board.isAnyPieceAt(new Position(6,2)));
    }

    @Test
    public void moveBishop7() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        bishop.move(new Position(2,2));
        assertFalse(board.isAnyPieceAt(new Position(4,4)));
        assertTrue(board.isAnyPieceAt(new Position(2,2)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishop8() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.WHITE, new Position(3,3), board);
        bishop.move(new Position(2, 2));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishop9() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.WHITE, new Position(3,3), board);
        bishop.move(new Position(0, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishop10() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4, 4), board);
        new Bishop(Team.WHITE, new Position(2, 2), board);
        bishop.move(new Position(0, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishop11() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.WHITE, new Position(1,1), board);
        bishop.move(new Position(0, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishop12() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.WHITE, new Position(5,3), board);
        bishop.move(new Position(7, 1));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishop13() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.WHITE, new Position(6,2), board);
        bishop.move(new Position(7, 1));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveBishop14() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.WHITE, new Position(7,1), board);
        bishop.move(new Position(7, 1));
    }

    @Test
    public void moveBishop15() throws OutOfBoardException, InvalidMovimentException {
        bishop = new Bishop(Team.WHITE, new Position(4,4), board);
        new Bishop(Team.BLACK, new Position(7,1), board);
        bishop.move(new Position(7, 1));
    }
}
