package com.spaceagencies.common.game;


public class Player extends GameEntity {

    private String login;

    private boolean human;

    private boolean local;

    
	public Player(Game game, long id, String login) {
	    super(game, id);
        this.login = login;
        
        human = false;
	}
	
    public String getLogin() {
        return login;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }

    public boolean isHuman() {
        return human;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }
    
    public boolean isLocal() {
        return local;
    }
}
