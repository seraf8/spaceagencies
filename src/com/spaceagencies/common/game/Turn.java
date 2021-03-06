package com.spaceagencies.common.game;

public class Turn {
    private Player player;
    private int actionCount = 1;
    private int buyCount = 1;
    private int moneyCount = 0;
    private CardPile mHand = new NormalCardPile();
    
    public Turn(Player player, CardPile deck) {
        super();
        this.player = player;
        for (int i = 0; i < 5; i++) {
            //TODO check if enought cards
            
            Card card = draw();
            if(card !=null) {
                mHand.addTop(card);
            }
        }
    }

    private Card draw() {
        
        if(player.getDeck().getNbCards() == 0) {
            // Discard pile as deck
            while(player.getDiscardPile().getNbCards() > 0) {
                player.getDeck().addTop(player.getDiscardPile().takeTop());    
            }
            player.getDeck().shuffle();
        }
        
        if(player.getDeck().getNbCards() == 0) {
            return null;
        } else {
            return player.getDeck().takeTop();    
        }
    }

    public final void addActions(int nb) {
        actionCount += nb;
    }
    
    public final Player getPlayer() {
        return player;
    }

    public final int getActionCount() {
        return actionCount;
    }

    public final int getBuyCount() {
        return buyCount;
    }

    public int getMoneyCount() {
        return moneyCount;
    }
    
    public final CardPile getHand() {
        return mHand;
    }

    public void doEnd() {
        
        // Discard hand
        while(mHand.getNbCards() > 0) {
            player.getDiscardPile().addTop(mHand.takeTop());    
        }
    }

}
