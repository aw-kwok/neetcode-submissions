class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int max = 1;
        while (max > 0) {
            if (i == nums.length - 1) return true;
            max--;
            max = Math.max(nums[i], max);
            i++;
        }
        return false;
    }
}
