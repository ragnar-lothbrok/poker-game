package com.game.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.game.constants.PokerConstants;
import com.game.enums.CardSuit;
import com.game.model.PokerHand;

public class PokerHandUtility {

    public static boolean isStraight(PokerHand pokerHand) {
        Set<Integer> rankSet = new TreeSet<Integer>();
        boolean isAcePresent = false;
        for (int i = 0; i < PokerConstants.CARDS_IN_HAND; i++) {
            if (pokerHand.getPokerHand().get(i).getCardRank().getType() == 'A') {
                isAcePresent = true;
            } else {
                rankSet.add(pokerHand.getPokerHand().get(i).getCardRank().getValue());
            }
        }
        if (rankSet.size() < 4) {
            return false;
        }

        List<Integer> tempList = new ArrayList<Integer>(rankSet);
        int min = tempList.get(0);
        int max = tempList.get(tempList.size() - 1);

        if (isAcePresent) {
            if (!(min == 0 || max == 11)) {
                return false;
            }
        }

        for (int i = 0; i < tempList.size(); i++) {
            if (tempList.get(i) != min + i) {
                return false;
            }
        }
        return true;
    }

    public static boolean isFlush(PokerHand pokerHand) {

        for (int i = 0; i < PokerConstants.CARDS_IN_HAND - 1; i++) {
            if (pokerHand.getPokerHand().get(i).getCardSuit() != pokerHand.getPokerHand().get(i + 1).getCardSuit()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Condition for Four of a kind
     * 
     * @return
     */
    public static boolean isFourOfAKind(PokerHand pokerHand) {
        Map<Integer, Integer> rankCountMap = getRankMap(pokerHand);
        if (rankCountMap.size() > 2) {
            return false;
        } else if (rankCountMap.size() == 1) {
            return true;
        } else {
            Iterator<Integer> keyIterator = rankCountMap.keySet().iterator();
            while (keyIterator.hasNext()) {
                if (rankCountMap.get(keyIterator.next()) == 4) {
                    return true;
                }
            }
        }
        return false;

    }

    public static Map<Integer, Integer> getRankMap(PokerHand pokerHand) {
        Map<Integer, Integer> rankCountMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < PokerConstants.CARDS_IN_HAND; i++) {
            if (rankCountMap.get(pokerHand.getPokerHand().get(i).getCardRank().getValue()) == null) {
                rankCountMap.put(pokerHand.getPokerHand().get(i).getCardRank().getValue(), 1);
            } else {
                rankCountMap.put(pokerHand.getPokerHand().get(i).getCardRank().getValue(),
                        rankCountMap.get(pokerHand.getPokerHand().get(i).getCardRank().getValue()) + 1);
            }
        }
        return rankCountMap;
    }
    
    @Deprecated
    public static Map<CardSuit, Integer> getSuitMap(PokerHand pokerHand) {
        Map<CardSuit, Integer> suitCountMap = new HashMap<CardSuit, Integer>();
        for (int i = 0; i < PokerConstants.CARDS_IN_HAND; i++) {
            if (suitCountMap.get(pokerHand.getPokerHand().get(i).getCardSuit()) == null) {
                suitCountMap.put(pokerHand.getPokerHand().get(i).getCardSuit(), 1);
            } else {
                suitCountMap.put(pokerHand.getPokerHand().get(i).getCardSuit(),
                        suitCountMap.get(pokerHand.getPokerHand().get(i).getCardSuit()) + 1);
            }
        }
        return suitCountMap;
    }

    public static boolean isFullHouse(PokerHand pokerHand) {

        if (isThreeOfAKind(pokerHand) == true && isOnePair(pokerHand) == true)
            return true;
        else
            return false;

    }

    public static boolean isThreeOfAKind(PokerHand pokerHand) {
        Map<Integer, Integer> rankCountMap = getRankMap(pokerHand);

        Iterator<Integer> keyIterator = rankCountMap.keySet().iterator();
        while (keyIterator.hasNext()) {
            int count = keyIterator.next();
            if (rankCountMap.get(count) == 3) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOnePair(PokerHand pokerHand) {
        Map<Integer, Integer> rankCountMap = getRankMap(pokerHand);
        Iterator<Integer> keyIterator = rankCountMap.keySet().iterator();
        while (keyIterator.hasNext()) {
            int count = keyIterator.next();
            if (rankCountMap.get(count) == 2) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHighCard(PokerHand pokerHand) {
        if (isOnePair(pokerHand) == false && isThreeOfAKind(pokerHand) == false && isFourOfAKind(pokerHand) == false
                && isFullHouse(pokerHand) == false && isFlush(pokerHand) == false && isStraight(pokerHand) == false) {
            return true;
        }
        return false;

    }

    public static String getType(PokerHand pokerHand) {
        if (isFourOfAKind(pokerHand) == true)
            return "four-­‐of-­‐a-­‐kind";
        if (isFullHouse(pokerHand) == true)
            return "full-­‐house";
        if (isFlush(pokerHand) == true)
            return "flush";
        if (isStraight(pokerHand) == true)
            return "straight";
        if (isThreeOfAKind(pokerHand) == true)
            return "three-­‐of-­‐a-­‐kind";
        if (isOnePair(pokerHand) == true)
            return "pair";
        if (isHighCard(pokerHand) == true)
            return "high-­‐card";
        return "";
    }
}
