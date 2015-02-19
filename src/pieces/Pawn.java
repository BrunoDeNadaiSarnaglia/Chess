package pieces;

import enumeration.Team;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;

import static java.lang.Math.abs;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Pawn extends Piece {

    public Pawn(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }

    public Pawn(Team team) {
        super(team);
    }

    /**
     * A Pawn can be moved:
     * - to one empty square in front of its previous position;
     * - to the second empty square in front of its previous position
     * if it is its first move in the game;
     * - to one square diagonally in front of its previous position
     * it that square is occupied by another player's piece.
     * @param newPosition the new position of the Pawn
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
        if(!((team == Team.BLACK && newRank - oldRank == 1 || team == Team.WHITE && newRank - oldRank == -1)
                || ((pieceInNewPosition != null && this.getTeam() != pieceInNewPosition.getTeam()) &&
                ((team == Team.BLACK && newRank - oldRank == 1 && abs(newFile - oldFile) == 1)
                        || (team == Team.WHITE && newRank - oldRank == -1 && abs(newFile - oldFile) == 1))))){
            return false;
        }
        return true;
    }

    @Override
    public Piece copy(Board board) throws OutOfBoardException {
        return new Pawn(team, position, board);
    }


    @Override
    public String toString() {
        if (team == Team.WHITE)
            return "\u2659";
        return "\u265F";
    }
}
