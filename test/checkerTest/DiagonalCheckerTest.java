package checkerTest;

import checker.DiagonalChecker;
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
public class DiagonalCheckerTest {

    private Board board;


    @Before
    public void iinitialize(){
        board = new Board();
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest1() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(0,0),new Position(7,7),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest2() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(3,3),new Position(7,7),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest3() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(0,0),new Position(5,5),board);
    }

    @Test
    public void diagonalCheckerTest4() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(0,0),new Position(4,4),board);
    }

    @Test
    public void diagonalCheckerTest5() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(4,4),new Position(7,7),board);
    }


    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest6() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(7,7),new Position(0,0),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest7() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(7,7), new Position(3,3),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest8() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(5,5), new Position(0,0),board);
    }

    @Test
    public void diagonalCheckerTest9() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(4,4), new Position(0,0),board);
    }

    @Test
    public void diagonalCheckerTest10() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(7,7),new Position(4,4),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest11() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(1,7),new Position(7,1),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest12() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(3,5),new Position(5,3),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest13() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(5,3),new Position(3,5),board);
    }

    @Test
    public void diagonalCheckerTest14() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(1,7),new Position(4,4),board);
    }

    @Test
    public void diagonalCheckerTest15() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(4,4),new Position(7,1),board);
    }


    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest16() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(7,1),new Position(1,7),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest17() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(5,3), new Position(3,5),board);
    }

    @Test(expected = PiecesInThePathException.class)
    public void diagonalCheckerTest18() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(5,3), new Position(3,5),board);
    }

    @Test
    public void diagonalCheckerTest19() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(7,1), new Position(4,4),board);
    }

    @Test
    public void diagonalCheckerTest20() throws OutOfBoardException, PiecesInThePathException {
        Piece piece = new Bishop(Team.BLACK, new Position(4,4), board);
        DiagonalChecker.check(new Position(1,7),new Position(4,4),board);
    }
}
