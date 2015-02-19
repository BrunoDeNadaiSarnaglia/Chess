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
    public Piece piece;


    @Before
    public void settingTest(){
        board = new Board();
    }

    @Test(expected = OutOfBoardException.class)
    public void insertPieceOutOfBoard() throws OutOfBoardException {
        piece = new Knight(Team.WHITE, new Position(-1,0), board);
    }

    @Test
    public void insertPieceInsideBoard() throws OutOfBoardException {
        piece = new Knight(Team.WHITE, new Position(0,0), board);
    }

    @Test
    public void anyPieceInPosition() throws OutOfBoardException {
        piece = new Knight(Team.WHITE, new Position(1,0), board);
        assertTrue(board.isAnyPieceAt(new Position(1, 0)));
        assertFalse(board.isAnyPieceAt(new Position(0, 0)));
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
        assertTrue(game.getPlayerWhiteKing().isInCheck());
    }

}
