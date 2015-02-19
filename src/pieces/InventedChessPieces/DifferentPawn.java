package pieces.InventedChessPieces;

import enumeration.Team;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import pieces.Piece;

import static java.lang.Math.abs;

/**
 * Created by Bruno on 2/19/2015.
 */
public class DifferentPawn extends Piece {

    public DifferentPawn(Team team) {
        super(team);
    }

    /**
     * Constructor that
     * @param team the team of the DifferentPawn
     * @param position the position of the DifferentPawn
     * @param board the board which DifferentPawn will be inserted
     */

    public DifferentPawn(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }


    /**
     * A Different Pawn can be moved:
     * one step in the column if empty
     * diagonal if opponent there
     * @param newPosition the new position of the DifferentPawn
     * @return true if the Pawn can be moved, false otherwise
     */
    @Override
    public boolean isValidMoviment(Position newPosition) {
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
        Piece pieceInNewPosition = board.getPieceAt(newPosition);
        if(isSameTeamOrSamePosition(newPosition)){
            return false;
        }
        if(!((team == Team.BLACK && abs(newFile - oldFile) == 1 && newRank - oldRank == 1 && pieceInNewPosition == null
                || team == Team.WHITE && abs(newFile - oldFile) == 1 && newRank - oldRank == -1 && pieceInNewPosition == null)
                || ((pieceInNewPosition != null && this.getTeam() != pieceInNewPosition.getTeam()) &&
                ((team == Team.BLACK && newRank - oldRank == 1 && newFile == oldFile)
                        || (team == Team.WHITE && newRank - oldRank == -1 && abs(newFile - oldFile) == 0))))){
            return false;
        }
        return true;
    }

    /**
     * Method which create a new instance of DifferentPawn
     * @param board the board of the new instance
     * @return a new piece instance exactly equal to this one
     */
    @Override
    public Piece copy(Board board) throws OutOfBoardException {
        return new DifferentPawn(team, new Position(position), board);
    }

    @Override
    public String toString() {
        if (team == Team.WHITE)
            return "w";
        return "b";
    }
}
