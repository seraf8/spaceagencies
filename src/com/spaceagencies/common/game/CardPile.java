package com.spaceagencies.common.game;

public interface CardPile {

    public abstract void addTop(Card c);

    public abstract void addBottom(Card c);

    public abstract void shuffle();

    public abstract Card peekTop();

    public abstract Card peekBottom();

    public abstract Card takeTop();

    public abstract Card takeBottom();

    public abstract int getNbCards();

    public abstract boolean isInfinite();

}
