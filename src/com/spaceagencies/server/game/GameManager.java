package com.spaceagencies.server.game;

import com.spaceagencies.common.game.Game;
import com.spaceagencies.common.tools.Log;

public class GameManager {

    private MetaGame mActiveGame;
    private MetaGame mPreviousGame;

    public MetaGame createGame() {
        MetaGame game = new MetaGame();
        
        initGame(game.getGame());
        
        return game;
    }

    private void initGame(Game game) {
        
    }


    public void setActiveGame(MetaGame game) {
        mActiveGame = game;
        mPreviousGame = game;
    }
    
    public MetaGame getActiveGame() {
        return mActiveGame;
    }

    public MetaGame getPreviousGame() {
        return mPreviousGame;
    }

    public void save() {
        Log.log("Begin save");
        GameSerializer saver = new GameSerializer();
        saver.save(mActiveGame);
        
        
        Log.log("End save");
    }
}
