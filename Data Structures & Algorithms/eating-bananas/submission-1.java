class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }
        int min = 1;
        int soln = max;
        while (min <= max) {
            int k = (min + max) / 2;
            int hours = calcHours(piles, k);
            if (hours <= h) {
                soln = Math.min(k, soln);
                max = k - 1;
            }
            else min = k + 1;
        }
        return soln;
    }
    public int calcHours(int[] piles, int k) {
        int hours = 0;
        for(int pile : piles) {
            hours += Math.ceil((double) pile/k);
        }
        return hours;
    }
}
