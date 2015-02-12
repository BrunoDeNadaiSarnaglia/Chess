package gamePlay;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import pieces.*;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Game {

    private Player playerBlack;

    public King getPlayerWhiteKing() {
        return playerWhiteKing;
    }

    public King getPlayerBlackKing() {
        return playerBlackKing;
    }

    private King playerBlackKing;
    private Player playerWhite;
    private King playerWhiteKing;

    public Board getBoard() {
        return board;
    }

    private Board board;

    public Game(Player playerBlack, Player playerWhite, Board board) throws OutOfBoardException {
        this.playerBlack = playerBlack;
        this.playerWhite = playerWhite;
        this.board = board;
        initializeBoard();
    }

    private void initializeBoard() throws OutOfBoardException {
        initializeBlackTeam();
        initializeWhiteTeam();
    }

    private void initializeBlackTeam() throws OutOfBoardException {
        new Pawn(Team.BLACK, new Position(1,0), board);
        new Pawn(Team.BLACK, new Position(1,1), board);
        new Pawn(Team.BLACK, new Position(1,2), board);
        new Pawn(Team.BLACK, new Position(1,3), board);
        new Pawn(Team.BLACK, new Position(1,4), board);
        new Pawn(Team.BLACK, new Position(1,5), board);
        new Pawn(Team.BLACK, new Position(1,6), board);
        new Pawn(Team.BLACK, new Position(1,7), board);
        new Rook(Team.BLACK, new Position(0,0), board);
        new Knight(Team.BLACK, new Position(0,1), board);
        new Bishop(Team.BLACK, new Position(0,2), board);
        playerBlackKing = new King(Team.BLACK, new Position(0,3), board);
        new Queen(Team.BLACK, new Position(0,4), board);
        new Bishop(Team.BLACK, new Position(0,5), board);
        new Knight(Team.BLACK, new Position(0,6), board);
        new Rook(Team.BLACK, new Position(0,7), board);
    }

    private void initializeWhiteTeam() throws OutOfBoardException {
        new Pawn(Team.WHITE, new Position(6,0), board);
        new Pawn(Team.WHITE, new Position(6,1), board);
        new Pawn(Team.WHITE, new Position(6,2), board);
        new Pawn(Team.WHITE, new Position(6,3), board);
        new Pawn(Team.WHITE, new Position(6,4), board);
        new Pawn(Team.WHITE, new Position(6,5), board);
        new Pawn(Team.WHITE, new Position(6,6), board);
        new Pawn(Team.WHITE, new Position(6,7), board);
        new Rook(Team.WHITE, new Position(7,0), board);
        new Knight(Team.WHITE, new Position(7,1), board);
        new Bishop(Team.WHITE, new Position(7,2), board);
        playerWhiteKing = new King(Team.WHITE, new Position(7,3), board);
        new Queen(Team.WHITE, new Position(7,4), board);
        new Bishop(Team.WHITE, new Position(7,5), board);
        new Knight(Team.WHITE, new Position(7,6), board);
        new Rook(Team.WHITE, new Position(7,7), board);
    }

    public King getKing(Team team){
        if (team == Team.BLACK){
            return getPlayerBlackKing();
        }
        return getPlayerWhiteKing();
    }

    public boolean isInCheckMate(Team team) throws OutOfBoardException {
        King king = getKing(team);
        if(!king.isInCheck()){
            return false;
        }
        if (movingKingCanIEscape(team))
            return false;

        /*int rank = king.getPosition().getRank();
        int file = king.getPosition().getFile();
        for (int i = -1; i <= 1 ; i++) {
            for (int j = -1; j <= 1; j++) {
                Game game = this.copy();
                king = game.getKing(team);
                try{
                    king.move(new Position(rank + i, file + i));
                    if(!king.isInCheck())
                        return false;
                } catch (InvalidMovimentException e) {
                } catch (OutOfBoardException e) {

                }
            }
        }*/
        return true;
    }

    private boolean movingKingCanIEscape(Team team) throws OutOfBoardException {
        King king = getKing(team);
        int rank = king.getPosition().getRank();
        int file = king.getPosition().getFile();
        for (int i = -1; i <= 1 ; i++) {
            for (int j = -1; j <= 1; j++) {
                Game game = this.copy();
                king = game.getKing(team);
                try{
                    king.move(new Position(rank + i, file + i));
                    if(!king.isInCheck())
                        return true;
                } catch (InvalidMovimentException e) {
                } catch (OutOfBoardException e) {

                }
            }
        }
        return false;
    }

    private boolean killingOppCanIEscape(Team team) throws OutOfBoardException {
        King king = getKing(team);
        Piece piece = king.piecePuttingInCheck();
    }

    public Game copy() throws OutOfBoardException {
        return new Game(playerBlack.copy(), playerWhite.copy(), board.copy());
    }
}
