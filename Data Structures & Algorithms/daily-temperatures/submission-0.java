class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] soln = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().getKey()) {
                Pair<Integer, Integer> pastTemp = stack.pop();
                soln[pastTemp.getValue()] = i - pastTemp.getValue();
            }
            stack.push(new Pair(temperatures[i], i));
        }
        return soln;
    }
}
