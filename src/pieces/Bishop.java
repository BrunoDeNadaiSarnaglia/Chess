package pieces;

import checker.DiagonalChecker;
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
public class Bishop extends Piece {

    public Bishop(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }

    public Bishop(Team team) {
        super(team);
    }

    @Override
    public void move(Position newPosition) throws OutOfBoardException, InvalidMovimentException {
        if(board.isOutOfBounds(newPosition)){
            throw new OutOfBoardException();
        }

        if(!isValidMoviment(newPosition)){
            throw new InvalidMovimentException();
        }
        board.putPieceAt(this, newPosition);
        board.deletePiece(position);
        setPosition(newPosition);
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
        if(isSameTeamOrSamePosition(newPosition)){
            return false;
        }
        if(abs(oldRank - newRank) != abs(oldFile - newFile)){
            return false;
        }
        if(ArePiecesInPath(newPosition)){
            return false;
        }
        return true;
    }

    private boolean ArePiecesInPath(Position newPosition){
        try {
            DiagonalChecker.check(position, newPosition, board);
        } catch (PiecesInThePathException e) {
            return true;
        }
        return false;
    }

/*    private boolean ArePiecesInPath(Position newPosition){
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
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
    }*/


    public Piece copy(Board board) throws OutOfBoardException {
        return new Bishop(team, new Position(position), board);
    }

    @Override
    public String toString() {
        if (team == Team.WHITE)
            return "\u2657";
        return "\u265D";
    }
}
