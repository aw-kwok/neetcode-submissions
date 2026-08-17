class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int l = 0;
        int r = 1;
        int sum = Math.max(0, prices[r] - prices[l]);
        while (r < prices.length) {
            if (prices[r] - prices[l] < 0) {
                l = r;
            }
            else {
                sum = Math.max(sum, prices[r] - prices[l]);
                r++;
            }
        }
        return sum;
    }
}
