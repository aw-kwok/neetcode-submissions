class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> soln = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    soln.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;
                    while (l < nums.length && nums[l] == nums[l - 1]) l++;
                    while (r > 0 && r < nums.length - 1 && nums[r] == nums[r + 1]) r--;
                }
                else if (nums[i] + nums[l] + nums[r] < 0) {
                    l++;
                    while (l < nums.length && nums[l] == nums[l - 1]) l++;
                }
                else {
                    r--;
                    while (r > 0 && r < nums.length - 1 && nums[r] == nums[r + 1]) r--;
                }
            }
        }
        return soln;
    }
}
