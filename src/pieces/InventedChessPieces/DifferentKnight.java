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

    public DifferentKnight(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }

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

    @Override
    public Piece copy(Board board) throws OutOfBoardException {
        return new DifferentKnight(team, new Position(position), board);
    }

    @Override
    public String toString() {
        if (team == Team.WHITE)
            return "DKW";
        return "DKB";
    }
}
