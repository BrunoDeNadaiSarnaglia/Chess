package pieces;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;

import static java.lang.Math.abs;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Knight extends Piece {

    public Knight(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }

    public Knight(Team team) {
        super(team);
    }

    /**
     * A Knight can move forming an L-shape movement
     * @param newPosition new position of the Knight
     * @return true if the Knight can be moved, false otherwise
     */
    public boolean isValidMoviment(Position newPosition) {
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
        Piece pieceInNewPosition = board.getPieceAt(newPosition);
        if(pieceInNewPosition != null && this.getTeam() == pieceInNewPosition.getTeam()){
            return false;
        }
        if(!((abs(oldFile - newFile) == 2 && abs(oldRank - newRank) == 1)
            || (abs(oldFile - newFile) == 1 && abs(oldRank - newRank) == 2))){
            return false;
        }
       /*
        if((oldFile - newFile == 2 || oldFile - newFile == -2)
                && (oldRank - newRank != 1 && oldRank - newRank != -1)
                ||((oldFile - newFile == 1 || oldFile - newFile == -1)
                && (oldRank - newRank != 2 && oldRank - newRank != -2))){
            return false;
        }*/
        return true;
    }

    @Override
    public Piece copy(Board board) throws OutOfBoardException {
        return new Knight(team, position, board);
    }


    @Override
    public String toString() {
        if (team == Team.WHITE)
            return "\u2658";
        return "\u265E";
    }
}
