package com.spaceagencies.common.game;


public class Player extends GameEntity {

    private String login;

    private boolean human;

    private boolean local;

    private CardPile mDeck;
    
    private CardPile mDiscardPile;

    private Turn mTurn;
    
	public Player(Game game, long id, String login) {
	    super(game, id);
        this.login = login;
        
        mDeck = new NormalCardPile();
        mDiscardPile = new NormalCardPile();
        
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

    public CardPile getDeck() {
        return mDeck;
    }
    
    public CardPile getDiscardPile() {
        return mDiscardPile;
    }

    public void setTurn(Turn turn) {
        mTurn = turn;
    }
    
    public Turn getTurn() {
        return mTurn;
    }
}
