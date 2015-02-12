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
        if(!((team == Team.BLACK && newRank - oldRank == 1 || team == Team.WHITE && newRank - oldRank == -1)
                || ((pieceInNewPosition != null && this.getTeam() != pieceInNewPosition.getTeam()) &&
                ((team == Team.BLACK && newRank - oldRank == 1 && abs(newFile - oldFile) == 1)
                        || (team == Team.WHITE && newRank - oldRank == -1 && abs(newFile - oldFile) == 1))))){
            return false;
        }/*
        if(!((pieceInNewPosition != null && this.getTeam() != pieceInNewPosition.getTeam()) &&
                ((team == Team.BLACK && newRank - oldRank == 1 && abs(newFile - oldFile) == 1)
                || (team == Team.WHITE && newRank - oldRank == -1 && abs(newFile - oldFile) == 1)))){

            return false;
        }*/
        return true;
    }
}
