class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> soln = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        generateSubsets(nums, 0, stack, soln);
        return soln;
    }

    public void generateSubsets(int[] nums, int i, Stack<Integer> stack, List<List<Integer>> soln) {
        if (nums.length == i) {
            soln.add(new ArrayList<>(stack));
            return;
        }
        
        stack.add(nums[i]);
        generateSubsets(nums, i + 1, stack, soln);
        stack.pop();
        generateSubsets(nums, i + 1, stack, soln);
    }
}
