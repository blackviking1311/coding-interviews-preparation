package org.example.algorithms.recursion.hard;

import java.util.Arrays;

public class MaximumCapacityWithinBudget {

    private class KnapSack {
        private int cost;
        private int capacity;

        public KnapSack(int cost, int capacity) {
            this.cost = cost;
            this.capacity = capacity;
        }

        public int getCost() {
            return cost;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public int maxCapacity(int[] costs, int[] capacities, int budget) {
        int n = costs.length;

        KnapSack[] knapSacks = new KnapSack[n];
        for (int i = 0; i < n; i++) {
            knapSacks[i] = new KnapSack(costs[i], capacities[i]);
        }

        // dp[b] = max capacity with total cost exactly b
        int[] dp = new int[budget];

        for (KnapSack ks : knapSacks) {
            // STRICT: b < budget
            for (int b = budget - 1; b >= ks.getCost(); b--) {
                dp[b] = Math.max(
                        dp[b],
                        dp[b - ks.getCost()] + ks.getCapacity()
                );
            }
        }

        // max over all b < budget
        int max = 0;
        for (int b = 0; b < budget; b++) {
            max = Math.max(max, dp[b]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] costs = {4, 8, 5, 3};
        int[] capacity = {1, 5, 2, 7};
        int budget = 8;

        MaximumCapacityWithinBudget solver = new MaximumCapacityWithinBudget();
        int result = solver.maxCapacity(costs, capacity, budget);

        System.out.println("Maximum Capacity within Budget: " + result);
    }
}
