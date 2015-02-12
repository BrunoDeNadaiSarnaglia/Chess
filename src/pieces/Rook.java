package pieces;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Rook extends Piece {


    public Rook(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }



    /**
     * The Rook can move any number of squares along any rank or file
     * @param newPosition the new position of the Rook
     * @return true if the Rook can move, false otherwise
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
        if(oldRank == newRank && oldFile == newFile){
            return false;
        }
        if(oldRank != newRank && oldFile != newFile){
            return false;
        }
        if(ArePiecesInPath(newPosition)){
            return false;
        }
        return true;
    }

    private boolean ArePiecesInPath(Position newPosition){
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
        if(oldRank == newRank){
            for (int i = min(newFile,oldFile) + 1; i < max(newFile, oldFile); i++) {
                if(board.isAnyPieceAt(new Position(oldRank, i)))
                    return true;
            }
        }else{
            for (int i = min(newRank,oldRank) + 1; i < max(newRank,oldRank); i++) {
                if(board.isAnyPieceAt(new Position(i, oldFile)))
                    return true;
            }
        }
        return false;
    }
}
