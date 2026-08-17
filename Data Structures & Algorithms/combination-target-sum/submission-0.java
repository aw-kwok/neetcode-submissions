class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> soln = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        dfs(0, nums, target, stack, sum, soln);
        return soln;
    }

     public static void dfs(int i, int[] nums, int target, Stack<Integer> stack, int sum, List<List<Integer>> soln) {
            if (sum == target) {
                soln.add(new ArrayList<>(stack));
                return;
            }
            if (sum > target) return;
            while (i < nums.length) {
                stack.push(nums[i]);
                sum += nums[i];
                dfs(i, nums, target, stack, sum, soln);
                stack.pop();
                sum -= nums[i];
                i++;
            }
        }

}
