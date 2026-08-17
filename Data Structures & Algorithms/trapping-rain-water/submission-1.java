class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxL = 0;
        int maxR = 0;
        int soln = 0;
        while (l <= r) {
            if (maxL < maxR) {
                soln += Math.max(0, maxL - height[l]);
                maxL = Math.max(maxL, height[l]);
                l++;
            }
            else {
                soln += Math.max(0, maxR - height[r]);
                maxR = Math.max(maxR, height[r]);
                r--;
            }
        }
        return soln;
    }
}
