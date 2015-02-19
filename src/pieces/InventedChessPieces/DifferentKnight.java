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
public class DifferentKnight extends Piece{

    public DifferentKnight(Team team) {
        super(team);
    }

    /**
     * Constructor that
     * @param team the team of the DifferentKnight
     * @param position the position of the DifferentKnight
     * @param board the board which DifferentKnight will be inserted
     */

    public DifferentKnight(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }

    /**
     * A DifferentKnight can be moved:
     * Can make two steps in the column, row and diagonal
     * it can overlap pieces two
     * @param newPosition the new position of the DifferentKnight
     * @return true if the Pawn can be moved, false otherwise
     */

    @Override
    public boolean isValidMoviment(Position newPosition) {
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
        Piece pieceInNewPosition = board.getPieceAt(newPosition);
        if(pieceInNewPosition != null && this.getTeam() == pieceInNewPosition.getTeam()){
            return false;
        }
        if(!((abs(oldFile - newFile) == 2 && abs(oldRank - newRank) == 0)
                || (abs(oldFile - newFile) == 0 && abs(oldRank - newRank) == 2)
                || (abs(oldFile - newFile) == 2 && abs(oldRank - newRank) == 2))){
            return false;
        }
        return true;
    }


    /**
     * Method which create a new instance of DifferentKnight
     * @param board the board of the new instance
     * @return a new piece instance exactly equal to this one
     */

    @Override
    public Piece copy(Board board) throws OutOfBoardException {
        return new DifferentKnight(team, new Position(position), board);
    }

    @Override
    public String toString() {
        if (team == Team.WHITE)
            return "W";
        return "B";
    }
}
