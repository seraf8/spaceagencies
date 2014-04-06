package com.spaceagencies.server.game;

import com.spaceagencies.common.game.Game;

public class MetaGame {

    private Game mGame;
    
    public MetaGame() {
        mGame = new Game();
    }
    
    public void load() {
        
    }

    public Game getGame() {
        return mGame;
    }

}
