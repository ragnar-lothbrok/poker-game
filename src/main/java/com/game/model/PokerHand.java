package com.game.model;

import java.util.ArrayList;

import com.game.exception.PokerException;

public class PokerHand {
    public static final int CARDS_IN_HAND = 5;

    private ArrayList<PokerCard> pokerHand;

    public PokerHand() {
        this.pokerHand = new ArrayList<PokerCard>();
    }

    public ArrayList<PokerCard> getPokerHand() {
        return pokerHand;
    }

    public void addCard(PokerCard card) throws PokerException {
        if (pokerHand.contains(card)) {
            throw new PokerException("Card is already added.");
        } else if (pokerHand.size() < CARDS_IN_HAND) {
            pokerHand.add(card);
        } else {
            throw new PokerException("Can only add 5 cards");
        }
    }
}
