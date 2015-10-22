package com.game.enums;

public enum CardSuit {
    C(0), D(1), H(2), S(3);

    private int value;

    CardSuit(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static CardSuit getSuit(int ordinal) {
        switch (ordinal) {
            case 0:
                return C;
            case 1:
                return D;
            case 2:
                return H;
            case 3:
                return S;

            default:
                throw new RuntimeException("Invalid SUIT ordinal " + ordinal);
        }
    }
    
    public static CardSuit getSuit(char ordinal) {
        switch (ordinal) {
            case 'C':
                return CardSuit.C;
            case 'D':
                return CardSuit.D;
            case 'H':
                return CardSuit.H;
            case 'S':
                return CardSuit.S;

            default:
                throw new RuntimeException("Invalid SUIT ordinal " + ordinal);
        }
    }

    public String getImage() {
        return this.toString().substring(0, 1);
    }
}
