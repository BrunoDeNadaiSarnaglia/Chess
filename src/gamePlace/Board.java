package gamePlace;

import enumeration.Team;
import pieces.Knight;
import pieces.Piece;

import java.util.Arrays;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Board {

    private final int boardSize = 8;
    private Piece[][] pieces;

    public Board() {
        pieces = new Piece[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                pieces[i][j] = null;
            }
        }
    }

    public Piece[][] getPieces() {
        return pieces;
    }

    public Piece getPieceAt(int i, int j){
        return pieces[i][j];
    }

    public boolean isOutOfBounds(Position position) {
        int rank = position.getRank();
        int file = position.getFile();
        if((rank >= 0 && rank < boardSize) && (file >= 0 && file < boardSize)){
            return false;
        }
        return true;
    }

    public boolean isAnyPieceAt(Position position){
        return (getPieceAt(position) != null);
    }

    public void putPieceAt(Piece piece, Position position) {
        int rank = position.getRank();
        int file = position.getFile();
        pieces[rank][file] = piece;
    }

    public Piece getPieceAt(Position position) {
        int rank = position.getRank();
        int file = position.getFile();
        return getPieceAt(rank, file);
    }

    @Override
    public String toString() {
        String string = "";
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(pieces[i][j] == null) {
                    string += "null";
                }
                else{
                    string += "alguem";
                }
            }
            string += "\n";
        }
        return string;
    }

    public void deletePiece(Position position) {
        int rank = position.getRank();
        int file = position.getFile();
        pieces[rank][file] = null;
    }
}
