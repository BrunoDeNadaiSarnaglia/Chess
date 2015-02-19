package checker;

import exceptions.PiecesInThePathException;
import gamePlace.Board;
import gamePlace.Position;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by Bruno on 2/18/2015.
 */
public class StraightChecker{

    public static void check(Position position1, Position position2, Board board) throws PiecesInThePathException {
        int oldRank = position1.getRank();
        int oldFile = position1.getFile();
        int newRank = position2.getRank();
        int newFile = position2.getFile();
        if(oldRank == newRank){
            for (int i = min(newFile,oldFile) + 1; i < max(newFile, oldFile); i++) {
                if(board.isAnyPieceAt(new Position(oldRank, i)))
                    throw new PiecesInThePathException();
            }
        }else if(oldFile == newFile){
            for (int i = min(newRank,oldRank) + 1; i < max(newRank,oldRank); i++) {
                if(board.isAnyPieceAt(new Position(i, oldFile)))
                    throw new PiecesInThePathException();
            }
        }
    }
}
