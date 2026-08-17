class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // r = n
        // min k = 1
        int r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        int l = 1;
        int soln = r;
        while (l <= r) {
            int k = (l + r) / 2;
            int hours = hours(piles, k);
            if (hours <= h) {
                soln = Math.min(k, soln);
                r = k - 1;
            }
            else l = k + 1;

        }
        return soln;
        
    }
    public int hours(int[] piles, int k) {
        int count = 0;
        for (int pile : piles) {
            count += Math.ceil((double) pile / k);
        }
        return count;
    }
}
