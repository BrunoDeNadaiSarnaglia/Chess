package gamePlay;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.InvalidPlayException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import pieces.*;

/**
 * Created by Bruno on 2/12/2015.
 */
public class Game {

    private Player playerBlack;
    private King playerBlackKing;
    private Player playerWhite;
    private King playerWhiteKing;
    private Team teamPlaying = Team.WHITE;

    public Board getBoard() {
        return board;
    }

    private Board board;

    public Game(Player playerBlack, Player playerWhite, Board board) throws OutOfBoardException {
        this.playerBlack = playerBlack;
        this.playerWhite = playerWhite;
        this.board = board;
        this.playerBlackKing = null;
        this.playerWhiteKing = null;
    }

    public void setTeamPlaying(Team teamPlaying) {
        this.teamPlaying = teamPlaying;
    }

    public void initializeBoard() throws OutOfBoardException {
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

    public Team getTeamPlaying() {
        return teamPlaying;
    }

    public King getPlayerBlackKing() {
        return playerBlackKing;
    }

    public King getPlayerWhiteKing() {
        return playerWhiteKing;
    }

    public King getKing(Team team){
        if (team == Team.BLACK){
            return getPlayerBlackKing();
        }
        return getPlayerWhiteKing();
    }

    public void setPlayerBlackKing(King playerBlackKing) {
        this.playerBlackKing = playerBlackKing;
    }

    public void setPlayerWhiteKing(King playerWhiteKing) {
        this.playerWhiteKing = playerWhiteKing;
    }

    public void move(Position oldPosition, Position newPosition) throws OutOfBoardException, InvalidPlayException, InvalidMovimentException {
        if(board.isOutOfBounds(oldPosition) || board.isOutOfBounds(newPosition)){
            throw new OutOfBoardException();
        }
        Piece piece = board.getPieceAt(oldPosition);
        if(piece == null){
            throw new InvalidPlayException();
        }
        try {
            piece.move(newPosition);
        }catch (Exception e){
            return;
        }
        changeTeamPlaying();
    }

    public void changeTeamPlaying(){
        if(teamPlaying == Team.WHITE)
            teamPlaying = Team.BLACK;
        else
            teamPlaying = Team.WHITE;
    }

    public boolean isInCheckMate(Team team) throws OutOfBoardException {
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                Piece piece = board.getPieceAt(i,j);
                if(piece != null && piece.getTeam() == team && !movingPieceIsInCheck(new Position(i,j) ,team))
                    return false;
            }
        }
        return true;
    }

    private boolean movingPieceIsInCheck(Position position, Team team) throws OutOfBoardException {
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                Game game = this.copy();
                try {
                    game.move(position, new Position(i,j));
                    King king = game.getKing(team);
                    if(king != null && !king.isInCheck()) {
                        /*System.out.println(position);
                        System.out.println(new Position(i,j));
                        System.out.println(game.getBoard());*/
                        return false;
                    }
                } catch (InvalidPlayException e) {
                } catch (InvalidMovimentException e) {
                } catch (OutOfBoardException e) {
                }
            }
        }
        return true;
    }
/*
    public boolean isInCheckMate(Team team) throws OutOfBoardException, InvalidMovimentException {
        King king = getKing(team);
        if(!king.isInCheck()){
            return false;
        }
        if (movingKingCanIEscape(team))
            return false;
        */
/*if(killingOppCanIEscape(team))
            return false;*//*

        */
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
        }*//*

        return true;
    }

    private boolean movingKingCanIEscape(Team team) throws OutOfBoardException {
        King king = getKing(team);
        int rank = king.getPosition().getRank();
        int file = king.getPosition().getFile();
        System.out.print("king position:" + king.getPosition());
        for (int i = -1; i <= 1 ; i++) {
            for (int j = -1; j <= 1; j++) {

                System.out.print(new Position(rank + i, file + j));
                Game game = this.copy();
                king = game.getKing(team);
                System.out.print(king.getPosition());
                try{
                    System.out.print(new Position(rank + i, file + j));
                    king.move(new Position(rank + i, file + j));
                    System.out.print(new Position(rank + i, file + j));
                    if(!king.isInCheck())
                        return true;
                } catch (InvalidMovimentException e) {
                    System.out.print("brunuo");
                } catch (OutOfBoardException e) {

                }
            }
        }
        return false;
    }

    private boolean killingOppCanIEscape(Team team) throws OutOfBoardException, InvalidMovimentException {
        King king = getKing(team);
        Piece checkPiece = king.piecePuttingInCheck();
        Board board = this.board.copy();
        Position checkPiecePosition = checkPiece.getPosition();
        Team checkPieceTeam = checkPiece.getTeam();
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                Position position = new Position(i,j);
                if(board.isAnyPieceAt(position)){
                    Piece piece = board.getPieceAt(position);
                    if(checkPieceTeam != piece.getTeam() && piece.isValidMoviment(checkPiecePosition)) {
                        Game game = this.copy();
                        game.getBoard().getPieceAt(position).move(checkPiecePosition);
                        if(!game.getKing(team).isInCheck())
                            return true;
                    }
                }
            }
        }
        return false;
    }
*/

    public Game copy() throws OutOfBoardException {
        Game game = new Game(playerBlack.copy(), playerWhite.copy(), board.copy());
        Board board = game.getBoard();
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                Piece piece = board.getPieceAt(i,j);
                if(piece != null && piece.isKing()){
                    if(piece.getTeam() == Team.BLACK){
                        game.setPlayerBlackKing((King) piece);
                    }else{
                        game.setPlayerWhiteKing((King) piece);
                    }
                }
            }
        }
        game.setTeamPlaying(getTeamPlaying());
        return game;
    }
}
