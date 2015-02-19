package piecesTests.DifferentPiecesTests;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.InventedChessPieces.DifferentPawn;
import pieces.Rook;

/**
 * Created by Bruno on 2/19/2015.
 */
public class DifferentPawnTest {

    private Board board;

    @Before
    public void settingUp(){
        board = new Board();
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove1() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        differentPawn.move(new Position(2,4));
    }

    @Test
    public void DifferentPawnMove2() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        differentPawn.move(new Position(2,5));
    }

    @Test
    public void DifferentPawnMove3() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        differentPawn.move(new Position(2,3));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove4() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        differentPawn.move(new Position(0,5));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove5() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        differentPawn.move(new Position(0,3));
    }


    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove6() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        differentPawn.move(new Position(0,4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove7() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.WHITE,new Position(1,4), board);
        differentPawn.move(new Position(0,4));
    }

    @Test
    public void DifferentPawnMove8() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.WHITE,new Position(1,4), board);
        differentPawn.move(new Position(0,5));
    }

    @Test
    public void DifferentPawnMove9() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.WHITE,new Position(1,4), board);
        differentPawn.move(new Position(0,3));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove10() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.WHITE,new Position(1,4), board);
        differentPawn.move(new Position(2,5));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove11() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.WHITE,new Position(1,4), board);
        differentPawn.move(new Position(2,3));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove12() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.WHITE,new Position(1,4), board);
        differentPawn.move(new Position(2,4));
    }

    @Test
    public void DifferentPawnMove13() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        new Rook(Team.WHITE, new Position(2,4), board);
        differentPawn.move(new Position(2,4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove14() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        new Rook(Team.WHITE, new Position(2,5), board);
        differentPawn.move(new Position(2,5));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove15() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.BLACK,new Position(1,4), board);
        new Rook(Team.WHITE, new Position(2,3), board);
        differentPawn.move(new Position(2,3));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove16() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.WHITE,new Position(1,4), board);
        new Rook(Team.BLACK, new Position(0,5), board);
        differentPawn.move(new Position(0,5));
    }

    @Test(expected = InvalidMovimentException.class)
    public void DifferentPawnMove17() throws OutOfBoardException, InvalidMovimentException {
        DifferentPawn differentPawn = new DifferentPawn(Team.WHITE,new Position(1,4), board);
        new Rook(Team.BLACK, new Position(0,3), board);
        differentPawn.move(new Position(0,3));
    }
}
