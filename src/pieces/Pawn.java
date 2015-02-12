package pieces;

import enumeration.Team;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Pawn extends Piece {


    protected Pawn(Team team, Position position, Board board) throws OutOfBoardException {
        super(team, position, board);
    }

    @Override
    public void move(Position newPosition) {

    }

    @Override
    protected boolean isValidMoviment(Position newPosition) {
        return false;
    }
}
