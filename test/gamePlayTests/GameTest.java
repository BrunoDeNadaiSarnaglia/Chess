package gamePlayTests;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.InvalidPlayException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import gamePlay.Game;
import gamePlay.Player;
import org.junit.Test;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bruno on 2/19/2015.
 */
public class GameTest {

    @Test
    public void testCopy() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game1 = new Game(new Player(), new Player(), new Board());
        game1.initializeBoard();
        Game game2 = game1.copy();
        game1.move(new Position(1,4), new Position(2,4));
        assertFalse(game1.getBoard().isAnyPieceAt(new Position(1, 4)));
        assertTrue(game1.getBoard().isAnyPieceAt(new Position(2, 4)));
        assertTrue(game2.getBoard().isAnyPieceAt(new Position(1, 4)));
    }

    @Test
    public void testKingPointer1() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game1 = new Game(new Player(), new Player(), new Board());
        game1.initializeBoard();
        Game game2 = game1.copy();
        game1.move(new Position(1,3), new Position(2,3));
        game1.move(new Position(0,3), new Position(1,3));
        assertEquals(game2.getPlayerBlackKing().getPosition().toString(), "(0, 3)");
        assertEquals(game1.getPlayerBlackKing().getPosition().toString(), "(1, 3)");
    }

    @Test
    public void testKingPointer2() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game1 = new Game(new Player(), new Player(), new Board());
        game1.initializeBoard();
        Game game2 = game1.copy();
        game2.move(new Position(1,3), new Position(2,3));
        game2.move(new Position(0,3), new Position(1,3));
        assertEquals(game1.getPlayerBlackKing().getPosition().toString(), "(0, 3)");
        assertEquals(game2.getPlayerBlackKing().getPosition().toString(), "(1, 3)");
    }
    @Test
    public void testCopy3() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game1 = new Game(new Player(), new Player(), new Board());
        game1.initializeBoard();
        game1.move(new Position(1,2), new Position(2,2));
        Game game2 = game1.copy();

    }

    @Test
    public void testIsInCheckMate1() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game = new Game(new Player(), new Player(), new Board());
        game.initializeBoard();
        Board board = game.getBoard();
        board.deletePiece(new Position(1,3));
        new Rook(Team.WHITE, new Position(3,3), board);
        assertFalse(game.isInCheckMate(Team.BLACK));
        game.isInCheckMate(Team.BLACK);
    }

    @Test
    public void testIsInCheckMate2() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game = new Game(new Player(), new Player(), new Board());
        game.initializeBoard();
        Board board = game.getBoard();
        board.deletePiece(new Position(1,3));
        board.deletePiece(new Position(0,1));
        new Rook(Team.WHITE, new Position(3,3), board);
        assertFalse(game.isInCheckMate(Team.BLACK));
        game.isInCheckMate(Team.BLACK);
    }

    @Test
    public void testIsInCheckMate3() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game = new Game(new Player(), new Player(), new Board());
        game.initializeBoard();
        Board board = game.getBoard();
        board.deletePiece(new Position(1,3));
        board.deletePiece(new Position(0,1));
        board.deletePiece(new Position(0,2));
        new Rook(Team.WHITE, new Position(3,3), board);
        assertFalse(game.isInCheckMate(Team.BLACK));
        game.isInCheckMate(Team.BLACK);
    }

    @Test
    public void testIsInCheckMate4() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game = new Game(new Player(), new Player(), new Board());
        game.initializeBoard();
        Board board = game.getBoard();
        board.deletePiece(new Position(1,3));
        board.deletePiece(new Position(0,1));
        board.deletePiece(new Position(0,2));
        new Pawn(Team.BLACK, new Position(0,2), board);
        new Rook(Team.WHITE, new Position(3,3), board);
        assertFalse(game.isInCheckMate(Team.BLACK));
        game.isInCheckMate(Team.BLACK);
    }

    @Test
    public void testIsInCheckMate5() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game = new Game(new Player(), new Player(), new Board());
        game.initializeBoard();
        Board board = game.getBoard();
        board.deletePiece(new Position(1,3));
        board.deletePiece(new Position(0,1));
        board.deletePiece(new Position(0,2));
        board.deletePiece(new Position(0,4));
        new Pawn(Team.BLACK, new Position(0,2), board);
        new Rook(Team.WHITE, new Position(3,3), board);
        assertFalse(game.isInCheckMate(Team.BLACK));
        game.isInCheckMate(Team.BLACK);
    }

    @Test
    public void testIsInCheckMate6() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game = new Game(new Player(), new Player(), new Board());
        game.initializeBoard();
        Board board = game.getBoard();
        board.deletePiece(new Position(1,3));
        board.deletePiece(new Position(0,1));
        board.deletePiece(new Position(0,2));
        board.deletePiece(new Position(0,4));
        new Pawn(Team.BLACK, new Position(0,2), board);
        new Pawn(Team.BLACK, new Position(0,4), board);
        new Rook(Team.WHITE, new Position(3,3), board);
        assertTrue(game.isInCheckMate(Team.BLACK));
        game.isInCheckMate(Team.BLACK);
    }

    @Test
    public void testIsInCheckMate7() throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        Game game = new Game(new Player(), new Player(), new Board());
        game.initializeBoard();
        Board board = game.getBoard();
        board.deletePiece(new Position(1,3));
        board.deletePiece(new Position(0,1));
        board.deletePiece(new Position(0,2));
        board.deletePiece(new Position(0,4));
        new Pawn(Team.BLACK, new Position(0,2), board);
        new Pawn(Team.BLACK, new Position(0,4), board);
        new Rook(Team.WHITE, new Position(3,3), board);
        new Queen(Team.BLACK, new Position(3,0), board);
        assertFalse(game.isInCheckMate(Team.BLACK));
        game.isInCheckMate(Team.BLACK);
    }
}
