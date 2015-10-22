package com.game.model;

import com.game.enums.CardRank;
import com.game.enums.CardSuit;

public class PokerCard implements Comparable<PokerCard> {
    private CardSuit cardSuit;
    private CardRank cardRank;

    public PokerCard(CardSuit cardSuit, CardRank cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public CardSuit getCardSuit() {
        return cardSuit;
    }

    public CardRank getCardRank() {
        return cardRank;
    }

    public String toString() {
        return this.cardRank.getImage() + this.cardSuit.getImage();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cardRank == null) ? 0 : cardRank.hashCode());
        result = prime * result + ((cardSuit == null) ? 0 : cardSuit.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PokerCard other = (PokerCard) obj;
        if (cardRank != other.cardRank)
            return false;
        if (cardSuit != other.cardSuit)
            return false;
        return true;
    }

    public int compareTo(PokerCard other) {
        return this.getCardRank().compareTo(other.getCardRank()) == 0 ? this.getCardSuit().compareTo(
                other.getCardSuit()) : 0;
    }
}
