package com.mycompany.knapsack;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Knapsack {

    public static void main(String[] args) {
        
        int[] energies = {5, 8, 6, 4, 10, 7};
        int[] weights = {3, 6, 4, 2, 7, 5};
        
        int capacity = 18;

        int[][] dp = new int[weights.length + 1][capacity + 1];

        for (int i = 1; i <= weights.length; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + energies[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println("Maximum Energy: " + dp[weights.length][capacity]);
        System.out.println("Selected Artifacts:");

        int i = weights.length;
        int w = capacity;
        while (i > 0 && w > 0) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println("Artifact " + (char) ('A' + i - 1) + ": Energy = " + energies[i - 1] + ", Weight = " + weights[i - 1]);
                w -= weights[i - 1];
            }
            i--;
        }
    }
}


