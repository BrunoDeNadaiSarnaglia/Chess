package checkerTest;

import checker.DiagonalChecker;
import checker.StraightChecker;
import enumeration.Team;
import exceptions.OutOfBoardException;
import exceptions.PiecesInThePathException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.Bishop;
import pieces.Piece;

/**
 * Created by Bruno on 2/18/2015.
 */
public class StraightCheckerTest {

    private Board board;


    @Before
    public void iinitialize(){
        board = new Board();
    }

    @Test
    public void straightCheckerTest1() throws OutOfBoardException, PiecesInThePathException {
        new Bishop(Team.BLACK, new Position(4,4), board);
        StraightChecker.check(new Position(0, 0), new Position(7, 7), board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void straightCheckerTest2() throws OutOfBoardException, PiecesInThePathException {
        new Bishop(Team.BLACK, new Position(4,4), board);
        StraightChecker.check(new Position(4, 0), new Position(4, 7), board);
    }

    @Test
    public void straightCheckerTest3() throws OutOfBoardException, PiecesInThePathException {
        new Bishop(Team.BLACK, new Position(4,4), board);
        StraightChecker.check(new Position(4, 4), new Position(4, 7), board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void straightCheckerTest4() throws OutOfBoardException, PiecesInThePathException {
        new Bishop(Team.BLACK, new Position(4,4), board);
        StraightChecker.check(new Position(4,3), new Position(4, 7), board);
    }

    @Test
    public void straightCheckerTest5() throws OutOfBoardException, PiecesInThePathException {
        new Bishop(Team.BLACK, new Position(4,4), board);
        StraightChecker.check(new Position(7, 7), new Position(0,0), board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void straightCheckerTest6() throws OutOfBoardException, PiecesInThePathException {
        new Bishop(Team.BLACK, new Position(4,4), board);
        StraightChecker.check(new Position(0, 4), new Position(7,4), board);
    }

    @Test
    public void straightCheckerTest7() throws OutOfBoardException, PiecesInThePathException {
        new Bishop(Team.BLACK, new Position(4,4), board);
        StraightChecker.check(new Position(4, 4), new Position(7,4), board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void straightCheckerTest8() throws OutOfBoardException, PiecesInThePathException {
        new Bishop(Team.BLACK, new Position(4,4), board);
        StraightChecker.check(new Position(3,4), new Position(7,4), board);
    }
}
