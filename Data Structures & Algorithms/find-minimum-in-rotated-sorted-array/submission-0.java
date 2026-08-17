class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[l] <= nums[r]) return nums[l];
            // if number is to the right
            else if (nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }
        return -1;
    }
}
