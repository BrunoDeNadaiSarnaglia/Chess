import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import gamePlay.Game;
import gamePlay.Player;
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
    public Game game;
    public Piece knight;
    public Piece rook;
    public Piece bishop;
    public Piece queen;
    public Piece king;
    public Piece pawn;


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

    @Test(expected = InvalidMovimentException.class)
    public void moveKnightWr() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(0,6), board);
        knight.move(new Position(7, 3));
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

    @Test(expected = InvalidMovimentException.class)
    public void mobeKing() throws OutOfBoardException, InvalidMovimentException {
        king = new King(Team.WHITE, new Position(4,3), board);
        king.move(new Position(7,6));

    }

    @Test
    public void mobeKing2() throws OutOfBoardException, InvalidMovimentException {
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


    @Test
    public void movePawn() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.BLACK, new Position(4,3), board);
        pawn.move(new Position(5,3));
    }


    @Test(expected = InvalidMovimentException.class)
    public void movePawn2() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.BLACK, new Position(4,3), board);
        pawn.move(new Position(3,3));
    }


    @Test
    public void movePawn3() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.WHITE, new Position(4,3), board);
        pawn.move(new Position(3,3));
    }


    @Test(expected = InvalidMovimentException.class)
    public void movePawn4() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.WHITE, new Position(4,3), board);
        pawn.move(new Position(5,3));
    }


    @Test(expected = InvalidMovimentException.class)
    public void movePawn5() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.WHITE, new Position(4,3), board);
        pawn.move(new Position(5,2));
    }


    @Test
    public void movePawn6() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.WHITE, new Position(4,3), board);
        new King(Team.BLACK, new Position(3,2), board);
        pawn.move(new Position(3,2));
    }

    @Test(expected = InvalidMovimentException.class)
    public void movePawn7() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.WHITE, new Position(4,3), board);
        new King(Team.WHITE, new Position(3,2), board);
        pawn.move(new Position(3,2));
    }


    @Test
    public void movePawn8() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.BLACK, new Position(4,3), board);
        new King(Team.WHITE, new Position(5,2), board);
        pawn.move(new Position(5,2));
    }

    @Test(expected = InvalidMovimentException.class)
    public void movePawn9() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.BLACK, new Position(4,3), board);
        new King(Team.WHITE, new Position(3,2), board);
        pawn.move(new Position(3,2));
    }

    @Test
    public void copyBoard() throws OutOfBoardException, InvalidMovimentException {
        new Pawn(Team.BLACK, new Position(4,3), board);
        new King(Team.WHITE, new Position(3,2), board);
        Board board = this.board.copy();
        assertTrue(board.isAnyPieceAt(new Position(4,3)));
        assertTrue(board.isAnyPieceAt(new Position(3,2)));
        board.deletePiece(new Position(3,2));
        assertFalse(board.isAnyPieceAt(new Position(3, 2)));
        assertTrue(this.board.isAnyPieceAt(new Position(3, 2)));
    }

    @Test
    public void initializingGame() throws OutOfBoardException{
        new Game(new Player(), new Player(), board);
//        System.out.println(board);
    }

    @Test
    public void testIfIsInCheck() throws OutOfBoardException{
        game = new Game(new Player(), new Player(), board);
        assertFalse(game.getPlayerBlackKing().isInCheck());
    }


    @Test
    public void testIfIsInCheckTrue() throws OutOfBoardException{
        game = new Game(new Player(), new Player(), board);
        board.deletePiece(new Position(1,3));
        board.deletePiece(new Position(6,3));
        board.putPieceAt(new Rook(Team.BLACK, new Position(1,3), board), new Position(1,3));
//        System.out.print(board);
        assertTrue(game.getPlayerWhiteKing().isInCheck());
    }
    @Test
    public void testIfIsInCheckTrueMate() throws OutOfBoardException, InvalidMovimentException {
        game = new Game(new Player(), new Player(), board);
        board.deletePiece(new Position(1,3));
        board.deletePiece(new Position(6,3));
        board.putPieceAt(new Rook(Team.BLACK, new Position(1, 3), board), new Position(1, 3));
        assertTrue(game.getPlayerWhiteKing().isInCheck());
        assertTrue(game.isInCheckMate(Team.WHITE));
        board.getPieceAt(new Position(7,3)).move(new Position(6,3));
        assertTrue(game.getPlayerWhiteKing().isInCheck());
        assertFalse(game.isInCheckMate(Team.BLACK));
    }


}
