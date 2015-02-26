package controller;

import exceptions.InvalidMovimentException;
import exceptions.InvalidPlayException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import gamePlay.Game;
import gamePlay.Player;
import gameTracker.GameTracker;
import pieces.Piece;
import view.ChessInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Bruno on 2/26/2015.
 */
public class chessController {

    private static Game game;
    private static Board board;
    static ChessInterface chessInterface;
    private static boolean isSelected = false;
    private static int firstRank;
    private static int firstFile;
    private static GameTracker gameTracker = new GameTracker();

    public chessController(Game game) {
        this.game = game;
        this.board = game.getBoard();
        defineButtonsReactions();
        try {
            gameTracker.addUndo(game.copy());
        } catch (OutOfBoardException e) {
        }
    }

    public static void setGame(Game game) {
        chessController.game = game;
        board = game.getBoard();
        /*try {
            gameTracker.addUndo(game.copy());
        } catch (OutOfBoardException e) {
        }*/
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
                        if(!(isSelected && file == firstFile && rank == firstRank) ){
                            if ((rank + file) % 2 == 1) {
                                button.setBackground(new Color(195, 214, 214));
                            } else {
                                button.setBackground(new Color(142, 156, 156));
                            }
                        }
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if(!isSelected){
                            if(board.isAnyPieceAt(new Position(rank, file))){
                                Piece piece = board.getPieceAt(new Position(rank, file));
                                if(piece.getTeam() == game.getTeamPlaying()){
                                    firstRank = rank;
                                    firstFile = file;
                                    button.setBackground(new Color(239, 127, 117));
                                    isSelected = true;
                                }
                            }
                        }else{
                            if(file == firstFile && rank == firstRank){
                                isSelected = false;
                                if((rank + file)%2 == 1){
                                    button.setBackground(new Color(195, 214, 214));
                                }else{
                                    button.setBackground(new Color(142, 156, 156));
                                }
                            }
                            try{
                                game.move(new Position(firstRank,firstFile), new Position(rank, file));
                            } catch (InvalidMovimentException e1) {
                                return;
                            } catch (InvalidPlayException e1) {
                                return;
                            } catch (OutOfBoardException e1) {
                                return;
                            }
                            try {
                                gameTracker.addUndo(game.copy());
                                gameTracker.deleteRedo();
                            } catch (OutOfBoardException e1) {
                            }
                            chessInterface.updateLabels();
                            isSelected = false;
                            JButton button = chessInterface.getJButton(new Position(firstRank, firstFile));
                            if((firstRank + firstFile)%2 == 1){
                                button.setBackground(new Color(195, 214, 214));
                            }else{
                                button.setBackground(new Color(142, 156, 156));
                            }
                            try {
                                if(game.isInCheckMate(game.getTeamPlaying())){
                                    Object[] objects = {"restart"};
                                    JOptionPane.showOptionDialog(null, "CheckMate", "",
                                            JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE, null, objects, objects[0]);
                                    restart();
                                    isSelected = false;
                                    chessInterface.updateLabels();
                                }
                            } catch (OutOfBoardException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
            }
        }
    }



    public static void restart(){
        try {
            Game game = new Game(new Player(), new Player(), new Board());
            game.initializeBoard();
            setGame(game);
            chessInterface.setGame(game);
            gameTracker.deleteRedo();
            gameTracker.deleteUndo();
            gameTracker.addUndo(game.copy());
        } catch (OutOfBoardException e) {
            e.printStackTrace();
        }
    }

    private static void setMenuActions(){
        chessInterface.getRestart().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    restart();
                    isSelected = false;
                    chessInterface.updateLabels();
                }
            }
        );
        chessInterface.getUndo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = gameTracker.getLastUndoGame();
                if(game == null)
                    return;
                setGame(game);
                chessInterface.setGame(game);
                isSelected = false;
                chessInterface.updateLabels();
            }
        });
        chessInterface.getRedo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Game game = gameTracker.getLastRedoGame();
                if(game == null)
                    return;
                setGame(game);
                chessInterface.setGame(game);
                isSelected = false;
                chessInterface.updateLabels();
            }
        });
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
                try {
                    gameTracker.addUndo(game.copy());
                } catch (OutOfBoardException e) {
                }
                defineButtonsReactions();
                setMenuActions();
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
