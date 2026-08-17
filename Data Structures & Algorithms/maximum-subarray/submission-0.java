class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i : nums) {
            if (currSum < 0) currSum = i;
            else {
                currSum += i;
            }
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
