package com.game.mains;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.game.service.PokerService;

public class MainClass {

    public static void main(String[] args) {

        PokerService pokerService = new PokerService();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please provide input [format :  HT, SJ, DQ, CK, HA ] : ");
            String line = br.readLine();
            String str[] = line.split(",");
            System.out.println(pokerService.calculateRank(str));
        } catch (Exception e) {
            System.out.println("Exception occured..." + e.getMessage());
        }
    }
}
