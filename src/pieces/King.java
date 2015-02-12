package pieces;

import enumeration.Team;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;

import static java.lang.Math.abs;

/**
 * Created by Bruno on 2/12/2015.
 */
public class King extends Piece {


    public King(Team team, Position position, Board board) throws OutOfBoardException {
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
        if(oldRank == newRank && oldFile == newFile){
            return false;
        }
        if(!(abs(oldRank - newRank) == 1 && (abs(oldFile - newFile) == 0 || abs(oldFile - newFile) == 1) ||
                abs(oldRank - newRank) == 0 && abs(oldFile - newFile) == 1)){
            return false;
        }
        return true;
    }



    public boolean isKing(){
        return true;
    }

}
