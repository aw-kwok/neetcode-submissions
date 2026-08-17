class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int soln = 0;
        while (l < r) {
            System.out.println((r - l) * Math.min(heights[l], heights[r]));
            soln = Math.max(soln, (r - l) * Math.min(heights[l], heights[r]));
            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return soln;
    }
}
