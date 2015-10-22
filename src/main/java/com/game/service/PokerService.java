package com.game.service;

import com.game.enums.CardRank;
import com.game.enums.CardSuit;
import com.game.exception.PokerException;
import com.game.model.PokerCard;
import com.game.model.PokerHand;
import com.game.utility.PokerHandUtility;
import com.game.utility.PokerHandValidationUtility;

public class PokerService {

    public String calculateRank(String[] cards) throws PokerException {
        if (cards.length != 5) {
            throw new PokerException("Can only add 5 cards");
        } else {
            PokerHand pokerHand = new PokerHand();
            for (int i = 0; i < cards.length; i++) {
                char cardSuit = cards[i].trim().charAt(0);
                char cardRank = cards[i].trim().charAt(1);
                pokerHand.addCard(new PokerCard(CardSuit.getSuit(cardSuit), CardRank.getRank(cardRank)));
            }
            PokerHandValidationUtility.validate(pokerHand);
            return PokerHandUtility.getType(pokerHand);
        }
    }

}
