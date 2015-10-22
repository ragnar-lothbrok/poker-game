package com.game.enums;

import com.game.exception.PokerException;

public enum CardRank {

    TWO('2', 0),
    THREE('3', 1),
    FOUR('4', 2),
    FIVE('5', 3),
    SIX('6', 4),
    SEVEN('7', 5),
    EIGHT('8', 6),
    NINE('9', 7),
    TEN('T', 8),
    JACK('J', 9),
    QUEEN('Q', 10),
    KING('K', 11),
    ACE('A', 12);

    private int value;
    private char type;

    CardRank(char type, int value) {
        this.type = type;
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
    
    public char getType() {
        return this.type;
    }

    public static CardRank getRank(int ordinal) {
        switch (ordinal) {
            case 0:
                return TWO;
            case 1:
                return THREE;
            case 2:
                return FOUR;
            case 3:
                return FIVE;
            case 4:
                return SIX;
            case 5:
                return SEVEN;
            case 6:
                return EIGHT;
            case 7:
                return NINE;
            case 8:
                return TEN;
            case 9:
                return JACK;
            case 10:
                return QUEEN;
            case 11:
                return KING;
            case 12:
                return ACE;

            default:
                throw new RuntimeException("Invalid RANK ordinal " + ordinal);
        }
    }

    public static CardRank getRank(char rank) throws PokerException {
        for (CardRank cardRank : CardRank.values()) {
            if (cardRank.type == rank) {
                return cardRank;
            }
        }
        throw new PokerException("Invalid rank.");
    }

    public String getImage() {
        if (this.getValue() < TEN.getValue())
            return "" + (this.getValue() + 2);

        return this.toString().substring(0, 1);
    }
}
