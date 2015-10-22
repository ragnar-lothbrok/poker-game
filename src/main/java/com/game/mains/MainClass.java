package com.game.mains;

import com.game.exception.PokerException;
import com.game.service.PokerService;

public class MainClass {

    public static void main(String[] args) {

        PokerService pokerService = new PokerService();
        try {
            System.out.println(pokerService.calculateRank(new String[] { "HT", "SJ", "DQ", "CK", "HA" }));

        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
        
        try {
            System.out.println(pokerService.calculateRank(new String[] { "H2", "S3", "D4", "C5", "H6" }));

        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
        
        try {

            System.out.println(pokerService.calculateRank(new String[] { "HA", "H2", "S3", "D4", "C5" }));

            
        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
        
        
        try {
            System.out.println(pokerService.calculateRank(new String[] { "H2", "C2", "D2", "S2", "H3" }));

           
        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
        
        
        try {
            System.out.println(pokerService.calculateRank(new String[] { "SA", "HA", "CA", "C2", "C5" }));

           
        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
        
        
        try {
            System.out.println(pokerService.calculateRank(new String[] { "SA", "HA", "C6", "C2", "C5" }));

           
        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
        
        
        try {
            System.out.println(pokerService.calculateRank(new String[] { "HA", "HK", "H2", "H4", "HT" }));

           
        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
        
        
        try {
            System.out.println(pokerService.calculateRank(new String[] { "S2", "D5", "C7", "ST", "HA" }));

           
        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
        
        
        try {
            System.out.println(pokerService.calculateRank(new String[] { "SA", "HA", "CA", "C5", "C5" }));
        } catch (PokerException e) {
            System.out.println("Exception occured..." + e.getMessage());
        }

    }
}
