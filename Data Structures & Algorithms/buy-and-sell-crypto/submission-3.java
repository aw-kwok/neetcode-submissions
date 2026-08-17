class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int l = 0;
        int r = 1;
        while (r < prices.length) {
            max = Math.max(max, prices[r] - prices[l]);
            System.out.println(prices[l]);
            System.out.println(prices[r]);
            while (prices[r] < prices[l]) {
                l++;
            }
            r++;
        }
        return max;
    }
}
