package com.game.utility;

import java.util.Map;

import com.game.exception.PokerException;
import com.game.model.PokerHand;

public class PokerHandValidationUtility {

    public static void validate(PokerHand pokerHand) throws PokerException{
        
        Map<Integer, Integer> rankMap =  PokerHandUtility.getRankMap(pokerHand);
        if(rankMap.size() == 1){
            throw new PokerException("Invalid cards");
        }
        
        
    }

    public static void validate(String[] cards) throws PokerException {
        for(int i=0;i<cards.length;i++){
            if(cards[i].trim().length() != 2){
                throw new PokerException("Invalid cards");
            }
        }
    }
    
}
