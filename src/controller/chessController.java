package controller;

import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlay.Game;
import gamePlay.Player;
import view.ChessInterface;

import javax.swing.*;

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
    }

    private static void defineButtonsReactions(){
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {

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
