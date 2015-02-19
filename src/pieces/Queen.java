package pieces;

import checker.DiagonalChecker;
import checker.StraightChecker;
import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import exceptions.PiecesInThePathException;
import gamePlace.Board;
import gamePlace.Position;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Queen extends Piece {

    public Queen(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }

    public Queen(Team team) {
        super(team);
    }

    /**
     * The Queen can move if the move is the same allowed by the Rook
     * or the Bishop
     * @param newPosition the new position of the Queen
     * @return true if the move is allowed, false otherwise
     */
    @Override
    public boolean isValidMoviment(Position newPosition) {
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
        if(isSameTeamOrSamePosition(newPosition)){
            return false;
        }
        if(abs(oldRank - newRank) != abs(oldFile - newFile) && oldRank != newRank && oldFile != newFile){
            return false;
        }
        if(ArePiecesInPath(newPosition)){
            return false;
        }
        return true;
    }

    private boolean ArePiecesInPath(Position newPosition) {
        try {
            DiagonalChecker.check(position, newPosition, board);
            StraightChecker.check(position, newPosition, board);
        } catch (PiecesInThePathException e) {
            return true;
        }
        return false;
    }


    public Piece copy(Board board) throws OutOfBoardException {
        return new Queen(team, position, board);
    }


    @Override
    public String toString() {
        if (team == Team.WHITE)
            return "\u2655";
        return "\u265B";
    }
}
