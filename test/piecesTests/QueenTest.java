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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bruno on 2/18/2015.
 */
public class QueenTest {

    private Board board;
    public Piece queen;

    @Before
    public void settingTest() {
        board = new Board();
    }

    @Test
    public void moveQueen() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 3), board);
        queen.move(new Position(7, 6));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
        assertTrue(board.isAnyPieceAt(new Position(7, 6)));
    }

    @Test
    public void moveQueen1() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 3), board);
        queen.move(new Position(1, 0));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
        assertTrue(board.isAnyPieceAt(new Position(1, 0)));
    }

    @Test
    public void moveQueen2() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 3), board);
        queen.move(new Position(7, 0));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
        assertTrue(board.isAnyPieceAt(new Position(7, 0)));
    }

    @Test
    public void moveQueen3() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 3), board);
        queen.move(new Position(1, 6));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
        assertTrue(board.isAnyPieceAt(new Position(1, 6)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueenWrongPath() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 3), board);
        queen.move(new Position(7, 1));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueenSomeoneInPath() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 3), board);
        new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(4, 5));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueenSomeoneInPath2() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 3), board);
        new Queen(Team.WHITE, new Position(3, 4), board);
        queen.move(new Position(2, 5));
    }

    @Test
    public void moveQueen4() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(0, 0));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(0, 0)));
    }

    @Test
    public void moveQueen5() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(7, 7));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(7, 7)));
    }

    @Test
    public void moveQueen6() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(1, 7));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(1, 7)));
    }

    @Test
    public void moveQueen7() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(7, 1));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(7, 1)));
    }

    @Test
    public void moveQueen8() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(4, 0));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(4, 0)));
    }

    @Test
    public void moveQueen9() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(4, 7));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(4, 7)));
    }

    @Test
    public void moveQueen10() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(0, 4));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(0, 4)));
    }

    @Test
    public void moveQueen11() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        queen.move(new Position(7, 4));
        assertFalse(board.isAnyPieceAt(new Position(4, 4)));
        assertTrue(board.isAnyPieceAt(new Position(7, 4)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen12() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        new Queen(Team.BLACK, new Position(1, 1), board);
        queen.move(new Position(0, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen13() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        new Queen(Team.WHITE, new Position(6, 6), board);
        queen.move(new Position(7, 7));
    }


    @Test(expected = InvalidMovimentException.class)
    public void moveQueen14() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(2,6), board);
        queen.move(new Position(1,7));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen15() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(6,2), board);
        queen.move(new Position(7, 1));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen16() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(4,1), board);
        queen.move(new Position(4,0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen17() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(4,6), board);
        queen.move(new Position(4,7));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen18() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(1,4), board);
        queen.move(new Position(0, 4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen19() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,4), board);
        new Queen(Team.WHITE, new Position(6,4), board);
        queen.move(new Position(7, 4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen20() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        new Queen(Team.WHITE, new Position(5, 5), board);
        queen.move(new Position(7, 7));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen21() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        new Queen(Team.BLACK, new Position(2, 2), board);
        queen.move(new Position(0, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueen22() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4, 4), board);
        new Queen(Team.BLACK, new Position(3, 3), board);
        queen.move(new Position(0, 0));
    }
}
