class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> soln = new ArrayList<>();

        dfs(nums, 0, target, stack, 0, soln);

        return soln;
    }

    private void dfs(int[] nums, int index, int target, Stack<Integer> stack, int sum, List<List<Integer>> soln) {
        if (sum == target) {
            soln.add(new ArrayList<>(stack));
            return;
        }
        if (sum > target) return;
        
        for (int i = index; i < nums.length; i++) {
            stack.push(nums[i]);
            sum += nums[i];
            dfs(nums, i, target, stack, sum, soln);
            sum -= nums[i];
            stack.pop();
        }
    }
}
