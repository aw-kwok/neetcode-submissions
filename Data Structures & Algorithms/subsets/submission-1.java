class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> soln = new ArrayList<>();
        dfs(stack, soln, nums, 0);
        return soln;
    }

    public void dfs(Stack<Integer> stack, List<List<Integer>> soln, int[] nums, int index) {
        if (index >= nums.length) {
            soln.add(new ArrayList<>(stack));
            return;
        }
        
        stack.push(nums[index]);
        dfs(stack, soln, nums, index + 1);
        stack.pop();
        dfs(stack, soln, nums, index + 1);
    }
}
