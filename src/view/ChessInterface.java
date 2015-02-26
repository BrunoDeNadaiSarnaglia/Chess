package view;

import enumeration.Team;
import exceptions.InvalidMovimentException;
import exceptions.InvalidPlayException;
import exceptions.OutOfBoardException;
import gamePlace.Board;
import gamePlace.Position;
import gamePlay.Game;
import gamePlay.Player;
import pieces.InventedChessPieces.DifferentKnight;
import pieces.Piece;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Bruno on 2/19/2015.
 */
public class ChessInterface {

    private static JPanel mainPanel;
    private static JPanel panel;
    private static JButton[][] boardOfButtons;
    private static Game game;
    private static Board board;
    private static JButton restart = new JButton("Restart");
    private static JButton undo = new JButton("Undo");
    private static JButton redo = new JButton("redo");



    /**
     * Constructor that will instantiate JComponents
     * and organize them into mainPanel
     * @param game that these JFrame will present
     */
    public ChessInterface(Game game) {
        this.game = game;
        this.board = game.getBoard();
        createGUI();
    }

    public JButton getRestart() {
        return restart;
    }

    public JButton getUndo() {
        return undo;
    }

    public JButton getRedo() {
        return redo;
    }

    public void setGame(Game game) {
        this.game = game;
        this.board = game.getBoard();
    }

    public Game getGame() {
        return game;
    }

    /**
     * method that instantiate JComponents used
     * in the GUI
     */

    private static void createGUI(){
        mainPanel = new JPanel(new BorderLayout(0, board.getBoardSize()+2));
        panel = new JPanel(new GridLayout(0, board.getBoardSize()+2));
        boardOfButtons = new JButton[board.getBoardSize()][board.getBoardSize()];
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setBorder(new LineBorder(Color.BLACK));
        initializeToolbars();
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

    /**
     * Initialize toolbars for the game
     */
    private static void initializeToolbars(){
        JToolBar toolBar = new JToolBar();
        toolBar.add(restart);
        toolBar.add(undo);
        toolBar.add(redo);
        toolBar.setFloatable(false);
        mainPanel.add(toolBar, BorderLayout.PAGE_START);

    }

    /**
     * Add JComponents in the mainPanel
     */
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

    public JButton getJButton(Position position){
        int rank = position.getRank();
        int file = position.getFile();
        return boardOfButtons[rank][file];
    }

    /**
     * Update all text presented in each JButton label with
     * Unicode of the element in this position
     */

    public void updateLabels(){
        for (int i = 0; i < board.getBoardSize(); i++) {
            for (int j = 0; j < board.getBoardSize(); j++) {
                JButton jButton = boardOfButtons[i][j];
                if(board.isAnyPieceAt(new Position(i,j))){
                    Piece piece = board.getPieceAt(new Position(i,j));
                    jButton.setText(piece.toString());
                }else{
                    jButton.setText("");
                }
            }
        }
    }
/*

    */
/**
     * Method to show the JFrame, not working yet
     *//*


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
*/

    /**
     * Main will display the JFrame of the current
     * Chess state
     */

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
