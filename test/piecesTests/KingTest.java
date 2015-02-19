package piecesTests;

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
 * Created by Bruno on 2/18/2015.
 */
public class KingTest {

    private Board board;
    private King king;
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
    public void moveKing1() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(4,4));
        assertTrue(board.isAnyPieceAt(new Position(4,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void moveKing2() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(4,2));
        assertTrue(board.isAnyPieceAt(new Position(4,2)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void moveKing3() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(5,3));
        assertTrue(board.isAnyPieceAt(new Position(5,3)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void moveKing4() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(5,4));
        assertTrue(board.isAnyPieceAt(new Position(5,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void moveKing5() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(5,2));
        assertTrue(board.isAnyPieceAt(new Position(5,2)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void moveKing6() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(3,3));
        assertTrue(board.isAnyPieceAt(new Position(3,3)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void moveKing7() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(3,2));
        assertTrue(board.isAnyPieceAt(new Position(3,2)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void moveKing8() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(3,4));
        assertTrue(board.isAnyPieceAt(new Position(3,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void moveKing9() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        new Queen(Team.BLACK, new Position(3,4), board);
        king.move(new Position(3,4));
        assertTrue(board.isAnyPieceAt(new Position(3,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveKing10() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        new Queen(Team.WHITE, new Position(3,4), board);
        king.move(new Position(3,4));
        assertTrue(board.isAnyPieceAt(new Position(3,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveKing11() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(4,5));
        assertTrue(board.isAnyPieceAt(new Position(3,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveKing12() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(6,3));
        assertTrue(board.isAnyPieceAt(new Position(3,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveKing13() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(2,3));
        assertTrue(board.isAnyPieceAt(new Position(3,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveKing14() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(4,1));
        assertTrue(board.isAnyPieceAt(new Position(3,4)));
        assertFalse(board.isAnyPieceAt(new Position(4, 3)));
    }

    @Test
    public void testIfIsKing() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        queen = new Queen(Team.WHITE, new Position(4,5), board);
        assertTrue(king.isKing());
        assertFalse(queen.isKing());
    }

    @Test
    public void kingInCheck1() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece = new Rook(Team.BLACK, new Position(4,5), board);
        assertTrue(king.isInCheck());
    }

    @Test
    public void kingInCheck2() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece = new Rook(Team.BLACK, new Position(3,5), board);
        assertFalse(king.isInCheck());
    }


    @Test
    public void kingInCheck3() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece = new Rook(Team.WHITE, new Position(4,5), board);
        assertFalse(king.isInCheck());
    }

    @Test
    public void kingInCheck4() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece = new Queen(Team.BLACK, new Position(4,5), board);
        assertTrue(king.isInCheck());
    }

    @Test
    public void kingInCheck5() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece = new Queen(Team.BLACK, new Position(5,4), board);
        assertTrue(king.isInCheck());
    }

    @Test
    public void kingInCheck6() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece = new Bishop(Team.BLACK, new Position(3,4), board);
        assertTrue(king.isInCheck());
    }

    @Test
    public void kingInCheck7() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece = new Knight(Team.BLACK, new Position(3,5), board);
        assertTrue(king.isInCheck());
    }

    @Test
    public void kingInCheck8() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece1 = new Knight(Team.BLACK, new Position(3,5), board);
        Piece piece2 = new Knight(Team.BLACK, new Position(0,0), board);
        assertTrue(king.isInCheck());
    }

    @Test
    public void kingInCheck9() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece1 = new Pawn(Team.BLACK, new Position(3,3), board);
        assertFalse(king.isInCheck());
    }

    @Test
    public void kingInCheck10() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece1 = new Pawn(Team.BLACK, new Position(3,2), board);
        assertTrue(king.isInCheck());
    }

    @Test
    public void kingInCheck11() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        Piece piece1 = new King(Team.BLACK, new Position(3,2), board);
        assertTrue(king.isInCheck());
    }

    @Test
    public void kingInCheck12() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        new King(Team.BLACK, new Position(2,2), board);
        new King(Team.BLACK, new Position(4,1), board);
        assertFalse(king.isInCheck());
    }
}
