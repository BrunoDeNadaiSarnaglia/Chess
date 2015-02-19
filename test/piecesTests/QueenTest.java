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
    public void settingTest(){
        board = new Board();
    }


    @Test
    public void moveQueen() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,3), board);
        queen.move(new Position(7,6));
        assertFalse(board.isAnyPieceAt(new Position(4,3)));
        assertTrue(board.isAnyPieceAt(new Position(7, 6)));
    }

    @Test
    public void moveQueen1() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,3), board);
        queen.move(new Position(1,0));
        assertFalse(board.isAnyPieceAt(new Position(4,3)));
        assertTrue(board.isAnyPieceAt(new Position(1,0)));
    }

    @Test
    public void moveQueen2() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,3), board);
        queen.move(new Position(7,0));
        assertFalse(board.isAnyPieceAt(new Position(4,3)));
        assertTrue(board.isAnyPieceAt(new Position(7,0)));
    }

    @Test
    public void moveQueen3() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,3), board);
        queen.move(new Position(1,6));
        assertFalse(board.isAnyPieceAt(new Position(4,3)));
        assertTrue(board.isAnyPieceAt(new Position(1,6)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueenWrongPath() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,3), board);
        queen.move(new Position(7, 1));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueenSomeoneInPath() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,3), board);
        new Queen(Team.WHITE, new Position(4,4), board);
        queen.move(new Position(4,5));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveQueenSomeoneInPath2() throws OutOfBoardException, InvalidMovimentException {
        queen = new Queen(Team.WHITE, new Position(4,3), board);
        new Queen(Team.WHITE, new Position(3,4), board);
        queen.move(new Position(2,5));
    }


}
