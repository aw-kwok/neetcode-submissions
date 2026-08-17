class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // -4, -1, -1, 0, 1, 2
        //      i   l           r
        // (-1, -1, 2)
        Arrays.sort(nums);
        List<List<Integer>> soln = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            if(nums[i] > 0) break;
            while(l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    soln.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    r--;
                    do l++;
                    while (l < nums.length && nums [l - 1] == nums[l]);
                }
                else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                }
                else {
                    l++;
                }
            }
        }
        return soln;
    }
}
