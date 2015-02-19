package piecesTests.DifferentPiecesTests;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.InventedChessPieces.DifferentKnight;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bruno on 2/19/2015.
 */
public class DifferentKnightTest {

    private Board board;
    private DifferentKnight differentKnight;

    @Before
    public void settingUp(){
        board = new Board();
    }

    @Test
    public void moveDifferentKnight1() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(4,4));
        assertTrue(board.isAnyPieceAt(new Position(4,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 2)));
    }

    @Test
    public void moveDifferentKnight2() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(6,2));
        assertTrue(board.isAnyPieceAt(new Position(6, 2)));
        assertFalse(board.isAnyPieceAt(new Position(4, 2)));
    }

    @Test
    public void moveDifferentKnight3() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(6,4));
        assertTrue(board.isAnyPieceAt(new Position(6, 4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 2)));
    }

    @Test
    public void moveDifferentKnight4() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(6,0));
        assertTrue(board.isAnyPieceAt(new Position(6, 0)));
        assertFalse(board.isAnyPieceAt(new Position(4, 2)));
    }

    @Test
    public void moveDifferentKnight5() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(4,0));
        assertTrue(board.isAnyPieceAt(new Position(4, 0)));
        assertFalse(board.isAnyPieceAt(new Position(4, 2)));
    }

    @Test
    public void moveDifferentKnight6() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(2,0));
        assertTrue(board.isAnyPieceAt(new Position(2, 0)));
        assertFalse(board.isAnyPieceAt(new Position(4, 2)));
    }

    @Test
    public void moveDifferentKnight7() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(2,2));
        assertTrue(board.isAnyPieceAt(new Position(2, 2)));
        assertFalse(board.isAnyPieceAt(new Position(4, 2)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveDifferentKnight8() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(5, 4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveDifferentKnight9() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(5, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveDifferentKnight10() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(6, 3));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveDifferentKnight11() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(2, 3));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveDifferentKnight12() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(3, 4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveDifferentKnight13() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(3, 0));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveDifferentKnight14() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(2, 3));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveDifferentKnight15() throws OutOfBoardException, InvalidMovimentException {
        differentKnight = new DifferentKnight(Team.BLACK, new Position(4,2), board);
        differentKnight.move(new Position(2, 1));
    }
}
