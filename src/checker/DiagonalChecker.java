package checker;

import exceptions.PiecesInThePathException;
import gamePlace.Board;
import gamePlace.Position;

import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 * Created by Bruno on 2/18/2015.
 */
public class DiagonalChecker{

    public static void check(Position position1, Position position2, Board board) throws PiecesInThePathException {
        int oldRank = position1.getRank();
        int oldFile = position1.getFile();
        int newRank = position2.getRank();
        int newFile = position2.getFile();
        if((oldRank - newRank)*(oldFile - oldRank) > 0){
            int rank = min(newRank,oldRank) + 1;
            int file = min(newFile,oldFile) + 1;
            for (int i = min(newFile,oldFile) + 1; i < max(newFile, oldFile); i++, rank++, file++) {
                if(board.isAnyPieceAt(new Position(rank, file)))
                    throw new PiecesInThePathException();
            }
        }else{
            int rank = min(newRank,oldRank) + 1;
            int file = max(newFile, oldFile) - 1;
            for (int i = min(newRank,oldRank) + 1; i < max(newRank,oldRank); i++, rank++, file--) {
                if(board.isAnyPieceAt(new Position(rank, file)))
                    throw new PiecesInThePathException();
            }
        }
    }

}
