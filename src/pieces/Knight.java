package pieces;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Knight extends Piece {


    public Knight(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }


    /**
     * A Knight can move forming an L-shape movement
     * @param newPosition new position of the Knight
     * @return true if the Knight can be moved, false otherwise
     */
    protected boolean isValidMoviment(Position newPosition) {
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
        Piece pieceInNewPosition = board.getPieceAt(newPosition);
        if(pieceInNewPosition != null && this.getTeam() == pieceInNewPosition.getTeam()){
            return false;
        }
        if((oldFile - newFile == 2 || oldFile - newFile == -2)
                && (oldRank - newRank != 1 && oldRank - newRank != -1)
                ||((oldFile - newFile == 1 || oldFile - newFile == -1)
                && (oldRank - newRank != 2 && oldRank - newRank != -2))){
            return false;
        }
        return true;
    }
}
