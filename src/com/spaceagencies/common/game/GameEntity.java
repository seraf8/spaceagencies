package com.spaceagencies.common.game;


public class GameEntity {
	private final long mId;
    private final Game mGame;
	
	public GameEntity(Game world, long id) {
        this.mGame = world;
        this.mId = id;
	}
	
	public long getId() {
        return mId;
    }
	
	public Game getWorld() {
        return mGame;
    }
}
