class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> soln = new ArrayList<>();
        dfs(stack, soln, nums, 0);
        return soln;
    }

    public void dfs(Stack<Integer> stack, List<List<Integer>> soln, int[] nums, int index) {
        soln.add(new ArrayList<>(stack));
        System.out.println(index + " " + stack);
        
        for (int i = index; i < nums.length; i++) {
            stack.push(nums[i]);
            dfs(stack, soln, nums, i + 1);
            stack.pop();
        }
    }
}
