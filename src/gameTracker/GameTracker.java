package gameTracker;

import gamePlay.Game;

import java.util.ArrayList;

/**
 * Created by Bruno on 2/26/2015.
 */
public class GameTracker {

    ArrayList<Game> listUndo = new ArrayList<Game>();
    ArrayList<Game> listRedo = new ArrayList<Game>();

    public void addUndo(Game game){
        listUndo.add(game);
        System.out.println(listUndo.size());
    }

    public Game getLastUndoGame(){
        if(/*listUndo.size() == 1 || */listUndo.size() == 0)
            return null;
        Game game = listUndo.get(listUndo.size() - 1);
        listUndo.remove(listUndo.size() - 1);
        addRedo(game);
        return game;
    }

    public Game getLastRedoGame(){
        if(listRedo.size() == 0)
            return null;
        Game game = listRedo.get(listRedo.size()-1);
        listRedo.remove(listRedo.size()-1);
        addUndo(game);
        return game;
    }

    public void addRedo(Game game){
        listRedo.add(game);
    }

    public void deleteRedo(){
        listRedo = new ArrayList<Game>();
    }

    public void deleteUndo(){
        listUndo = new ArrayList<Game>();
    }
}
