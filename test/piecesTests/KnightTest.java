package piecesTests;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import org.junit.Before;
import org.junit.Test;
import pieces.Knight;
import pieces.Piece;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Bruno on 2/18/2015.
 */
public class KnightTest {

    private Board board;
    public Piece knight;

    @Before
    public void settingTest(){
        board = new Board();
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
    public void moveKnight1() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(6, 6));
    }

    @Test
    public void moveKnight2() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(6, 4));
    }

    @Test
    public void moveKnight3() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(5, 7));
    }

    @Test
    public void moveKnight4() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(5, 3));
    }

    @Test
    public void moveKnight5() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(3, 7));
    }

    @Test
    public void moveKnight6() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(3, 3));
    }


    @Test
    public void moveKnight7() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(2, 6));
    }


    @Test
    public void moveKnight8() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(2, 4));
    }

    @Test(expected = InvalidMovimentException.class)
    public void moveKnight9() throws OutOfBoardException, InvalidMovimentException {
        knight = new Knight(Team.WHITE, new Position(4,5), board);
        knight.move(new Position(3, 4));
    }
}
