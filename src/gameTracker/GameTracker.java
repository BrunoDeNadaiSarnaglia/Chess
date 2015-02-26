package gameTracker;

import gamePlay.Game;

import java.util.ArrayList;

/**
 * Created by Bruno on 2/26/2015.
 */
public class GameTracker {

    ArrayList<Game> listUndo = new ArrayList<Game>();
    ArrayList<Game> listRedo = new ArrayList<Game>();

    Game currentGame = null;

    /**
     * Add game that was in the past to be used by undo button
     * @param game
     */

    public void addUndo(Game game){
        if(currentGame == null){
            currentGame = game;
            return;
        }
        listUndo.add(currentGame);
        currentGame = game;
    }

    /**
     * return what game should be undone
     * @return
     */

    public Game getLastUndoGame(){
        System.out.println(listUndo.size());
        if(/*listUndo.size() == 1 || */listUndo.size() == 0)
            return null;
        Game game = listUndo.get(listUndo.size() - 1);
        listUndo.remove(listUndo.size() - 1);
        addRedo(currentGame);
        currentGame = game;
        return game;
    }

    /**
     * return what game should be redone
     * @return
     */

    public Game getLastRedoGame(){
        if(listRedo.size() == 0)
            return null;
        Game game = listRedo.get(listRedo.size()-1);
        listRedo.remove(listRedo.size()-1);
        listUndo.add(currentGame);
        currentGame = game;
        return game;
    }


    /**
     * Add game that was in undo to be used by redo button
     * @param game
     */

    public void addRedo(Game game){
        listRedo.add(game);
    }

    /**
     * method that delete the data structures of games
     */

    public void deleteRedo(){
        listRedo = new ArrayList<Game>();
    }

    public void deleteUndo(){
        listUndo = new ArrayList<Game>();
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}
