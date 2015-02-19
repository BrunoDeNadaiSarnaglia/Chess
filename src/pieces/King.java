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
public class King extends Piece {

    public King(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }

    public King(Team team) {
        super(team);
    }

    /**
     * The King can move to any direction, one square at a time
     * @param newPosition new position of the King
     * @return true if the King can move, false otherwise
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
        if(!(abs(oldRank - newRank) == 1 && (abs(oldFile - newFile) == 0 || abs(oldFile - newFile) == 1) ||
                abs(oldRank - newRank) == 0 && abs(oldFile - newFile) == 1)){
            return false;
        }
        return true;
    }



    public boolean isKing(){
        return true;
    }

    public boolean isInCheck() throws OutOfBoardException {
        /*Board board = this.board.copy();
        Position kingPosition = getPosition();
        Team kingTeam = getTeam();
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                Position position = new Position(i,j);
                if(board.isAnyPieceAt(position)){
                    Piece piece = board.getPieceAt(position);
                    if(kingTeam != piece.getTeam() && piece.isValidMoviment(kingPosition)) {
                        return true;
                    }
                }
            }
        }
        return false;*/
        return (piecePuttingInCheck() != null);
    }

    public Piece piecePuttingInCheck() throws OutOfBoardException {
        Board board = this.board.copy();
        Position kingPosition = getPosition();
        Team kingTeam = getTeam();
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                Position position = new Position(i,j);
                if(board.isAnyPieceAt(position)){
                    Piece piece = board.getPieceAt(position);
                    if(kingTeam != piece.getTeam() && piece.isValidMoviment(kingPosition)) {
                        return piece;
                    }
                }
            }
        }
        return null;
    }

    public Piece copy(Board board) throws OutOfBoardException {
        return new King(team, position, board);
    }


    @Override
    public String toString() {
        if (team == Team.WHITE)
            return "\u2654";
        return "\u265A";
    }
}
