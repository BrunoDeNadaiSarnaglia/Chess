package pieces;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
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
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
        if(oldRank == newRank){
            for (int i = min(newFile,oldFile) + 1; i < max(newFile, oldFile); i++) {
                if(board.isAnyPieceAt(new Position(oldRank, i)))
                    return true;
            }
        }else if (oldFile == newFile){
            for (int i = min(newRank,oldRank) + 1; i < max(newRank,oldRank); i++) {
                if(board.isAnyPieceAt(new Position(i, oldFile)))
                    return true;
            }
        }

        if((oldRank - newRank)*(oldFile - oldRank) > 0){
            int rank = min(newRank,oldRank) + 1;
            int file = min(newFile,oldFile) + 1;
            for (int i = min(newFile,oldFile) + 1; i < max(newFile, oldFile); i++, rank++, file++) {
                if(board.isAnyPieceAt(new Position(rank, file)))
                    return true;
            }
        }else{
            int rank = min(newRank,oldRank) + 1;
            int file = max(newFile, oldFile) - 1;
            for (int i = min(newRank,oldRank) + 1; i < max(newRank,oldRank); i++, rank++, file--) {
                if(board.isAnyPieceAt(new Position(rank, file)))
                    return true;
            }
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
