package com.spaceagencies.common.game;

public class Turn {
    private Player player;
    private int actionCount = 1;
    private int buyCount = 1;
    private CardPile pile = new NormalCardPile();
    
    public Turn(Player player, CardPile deck) {
        super();
        this.player = player;
        for (int i = 0; i < 5; i++) {
            pile.addTop(deck.takeTop());
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

    public final CardPile getPile() {
        return pile;
    }

}
