import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bruno on 2/12/2015.
 */
public class BoardTest {

    private Board board;
    public Piece knight;
    public Piece rook;
    public Piece bishop;
    public Piece queen;


    @Before
    public void settingTest(){
        board = new Board();

    }

    @Test(expected = OutOfBoardException.class)
    public void insertPieceOutOfBoard() throws OutOfBoardException {
        knight = new Knight(Team.WHITE, new Position(-1,0), board);
    }

    @Test
    public void insertPieceInsideBoard() throws OutOfBoardException {
        knight = new Knight(Team.WHITE, new Position(0,0), board);
    }

    @Test
    public void anyPieceInPosition() throws OutOfBoardException {
        knight = new Knight(Team.WHITE, new Position(1,0), board);
        assertTrue(board.isAnyPieceAt(new Position(1, 0)));
        assertFalse(board.isAnyPieceAt(new Position(0, 0)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveKnightWrongPath() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(1,0), board);
        knight.move(new Position(2 ,1));

    }

    @Test
    public void moveKnight() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(1,0), board);
        knight.move(new Position(2, 2));
        assertTrue(board.isAnyPieceAt(new Position(2, 2)));
        assertFalse(board.isAnyPieceAt(new Position(1, 0)));
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
