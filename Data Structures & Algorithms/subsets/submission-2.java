class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> soln = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        soln.add(new ArrayList<Integer>());

        generateSubsets(nums, 0, stack, soln);
        return soln;
    }

    public void generateSubsets(int[] nums, int index, Stack<Integer> stack, List<List<Integer>> soln) {
        if (nums.length == index) return;
        for (int i = index; i < nums.length; i++) {
            stack.push(nums[i]);
            soln.add(new ArrayList<>(stack));
            generateSubsets(nums, i + 1, stack, soln);
            stack.pop();
        }
    }
}
