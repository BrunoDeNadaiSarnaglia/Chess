package pieces;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;

/**
 * Created by Bruno on 2/12/2015.
 */
public abstract class Piece {

    protected Team team;
    protected Position position;

    public Position getPosition() {
        return position;
    }

    public Team getTeam() {
        return team;
    }

    public void setPosition(Position position) {
        this.position.setRank(position.getRank());
        this.position.setFile(position.getFile());
    }

    protected Board board;

    protected Piece(Team team, Position position, Board board) throws OutOfBoardException {
        this.team = team;
        this.position = position;
        this.board = board;
        if(board.isOutOfBounds(position)){
            throw new OutOfBoardException();
        }
        board.putPieceAt(this, position);
    }

    //public abstract void move(Position newPosition) throws OutOfBoardException, InvalidMovimentException;

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

    public abstract boolean isValidMoviment(Position newPosition);

    protected boolean isSameTeamOrSamePosition(Position newPosition){
        int oldRank = position.getRank();
        int oldFile = position.getFile();
        int newRank = newPosition.getRank();
        int newFile = newPosition.getFile();
        Piece pieceInNewPosition = board.getPieceAt(newPosition);
        if(pieceInNewPosition != null && this.getTeam() == pieceInNewPosition.getTeam()){
            return true;
        }
        if(oldRank == newRank && oldFile == newFile){
            return true;
        }
        return false;
    }

    /**
     * subclass King override this method to return true
     */
    public boolean isKing(){
        return false;
    }


    public abstract Piece copy(Board board) throws OutOfBoardException;
}
