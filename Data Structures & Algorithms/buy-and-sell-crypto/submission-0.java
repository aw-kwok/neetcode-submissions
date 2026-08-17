class Solution {
    public int maxProfit(int[] prices) {
        int soln = 0;
        int buy = prices[0], sell = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                sell = prices[i];
            };
            if (prices[i] > sell) sell = prices[i];
            soln = Math.max(sell - buy, soln);
        }
        return soln;
    }
}
