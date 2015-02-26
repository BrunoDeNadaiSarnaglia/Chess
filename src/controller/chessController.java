package controller;

import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import gamePlay.Game;
import gamePlay.Player;
import pieces.Piece;
import view.ChessInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Bruno on 2/26/2015.
 */
public class chessController {

    private static Game game;
    private static Board board;
    static ChessInterface chessInterface;

    public chessController(Game game) {
        this.game = game;
        this.board = game.getBoard();
        defineButtonsReactions();
    }

    public static void setGame(Game game) {
        chessController.game = game;
        board = game.getBoard();
    }

    private static void defineButtonsReactions(){
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                final JButton button = chessInterface.getJButton(new Position(i, j));
                final int rank = i;
                final int file= j;
                button.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        if(board.isAnyPieceAt(new Position(rank, file))){
                            Piece piece = board.getPieceAt(new Position(rank, file));
                            if(piece.getTeam() == game.getTeamPlaying()){
                                button.setBackground(new Color(239, 127, 117));
                            }
                        }
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        if((rank + file)%2 == 1){
                            button.setBackground(new Color(195, 214, 214));
                        }else{
                            button.setBackground(new Color(142, 156, 156));
                        }
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                    }

                });
            }
        }
    }

    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Game game = null;
                try {
                    game = new Game(new Player(), new Player(),new Board());
                } catch (OutOfBoardException e) {
                    e.printStackTrace();
                }
                try {
                    game.initializeBoard();
                } catch (OutOfBoardException e) {
                }
                chessInterface = new ChessInterface(game);
                chessInterface.updateLabels();
                setGame(game);
                defineButtonsReactions();
                JFrame frame = new JFrame("Chess Game");
                frame.add(chessInterface.getMainPanel());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationByPlatform(true);
                frame.pack();
                frame.setMinimumSize(frame.getSize());
                frame.setVisible(true);
            }
        });

    }

}
