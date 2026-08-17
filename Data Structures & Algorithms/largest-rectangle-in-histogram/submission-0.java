class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        int[] pair = new int[2]; // [index, height]
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            while(!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] leftBar = stack.pop();
                max = Math.max(max, (i - leftBar[0]) * leftBar[1]);
                left = leftBar[0];
            }
            stack.push(new int[]{left, heights[i]});
        }
        while(!stack.isEmpty()) {
            int[] leftBar = stack.pop();
            max = Math.max(max, (heights.length - leftBar[0]) * leftBar[1]);
        }
        return max;
    }
}
