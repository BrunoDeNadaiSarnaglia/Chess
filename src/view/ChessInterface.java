package view;

import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import gamePlay.Game;
import gamePlay.Player;
import pieces.Piece;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Bruno on 2/19/2015.
 */
public class ChessInterface {

    private static JPanel mainPanel = new JPanel();
    private static JPanel panel;
    private static JButton[][] boardOfButtons;
    private static Game game;
    private static Board board;

    public ChessInterface(Game game) {
        this.game = game;
        this.board = game.getBoard();
        createGUI();
    }

    private static void createGUI(){
        panel = new JPanel(new GridLayout(0, board.getBoardSize()+2));
        boardOfButtons = new JButton[board.getBoardSize()][board.getBoardSize()];
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setBorder(new LineBorder(Color.BLACK));
        mainPanel.add(panel);
        Color black = new Color(195, 214, 214);
        Color white = new Color(142, 156, 156);
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                JButton jButton = new JButton();
                Dimension dimension = new Dimension(64,64);
                jButton.setMinimumSize(dimension);
                jButton.setPreferredSize(dimension);
                if((i + j)%2 == 1){
                    jButton.setBackground(black);
                }else{
                    jButton.setBackground(white);
                }
                jButton.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 24));
                jButton.setContentAreaFilled(false);
                jButton.setOpaque(true);
                jButton.setBorder(null);
                jButton.setBorderPainted(false);
                jButton.setFocusPainted(false);
                boardOfButtons[i][j] = jButton;
            }
        }
        fillPanel();
    }

    public static void fillPanel(){
        for(int i = 0; i < board.getBoardSize()+2; i++){
            panel.add(new JLabel(""));
        }
        for(int i = 0; i < board.getBoardSize(); i++){
            panel.add(new JLabel(Integer.toString(i + 1), SwingConstants.RIGHT));
            for(int j = 0; j < board.getBoardSize(); j++){
                panel.add(boardOfButtons[i][j]);
            }
            panel.add(new JLabel(""));
        }
        panel.add(new JLabel(""));
        char letter = 'A';
        for(int i = 0; i < board.getBoardSize(); letter++, i++){
            JLabel jLabel = new JLabel(Character.toString(letter), SwingConstants.CENTER);
            jLabel.setVerticalAlignment(SwingConstants.TOP);
            panel.add(jLabel);
        }
        panel.add(new JLabel(""));
    }

    public static JPanel getMainPanel() {
        return mainPanel;
    }

    private void updateLabels(){
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                if(board.isAnyPieceAt(new Position(i,j))){
                    JButton jButton = boardOfButtons[i][j];
                    Piece piece = board.getPieceAt(new Position(i,j));
                    jButton.setText(piece.toString());
                }
            }
        }
    }

    public void show(){
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
                    e.printStackTrace();
                }
                ChessInterface chessInterface = new ChessInterface(game);
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

    public static void main(String[] args) throws OutOfBoardException {
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
                    e.printStackTrace();
                }
                ChessInterface chessInterface = new ChessInterface(game);
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
