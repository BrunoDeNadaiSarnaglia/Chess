package piecesTests;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.King;
import pieces.Pawn;
import pieces.Piece;

/**
 * Created by Bruno on 2/18/2015.
 */
public class PawnTest {

    private Board board;
    public Piece pawn;

    @Before
    public void settingTest(){
        board = new Board();
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

    @Test
    public void movePawn82() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.BLACK, new Position(4,3), board);
        new King(Team.WHITE, new Position(5,4), board);
        pawn.move(new Position(5,2));
    }

    @Test(expected = InvalidMovimentException.class)
    public void movePawn9() throws OutOfBoardException, InvalidMovimentException {
        pawn = new Pawn(Team.BLACK, new Position(4,3), board);
        new King(Team.WHITE, new Position(3,2), board);
        pawn.move(new Position(3,2));
    }
}
