class Solution {
    public List<String> generateParenthesis(int n) {
        String stack = "";
        int open = 0;
        int close = 0;
        List<String> soln = new ArrayList<>();
        dfs(stack, open, close, n, soln);
        return soln;
    }
    public void dfs(String stack, int open, int close, int n, List<String> soln) {
        if (open == n && close == n) {
            soln.add(stack);
            return;
        }
        if (open < n) {
            stack = stack + "(";
            dfs(stack, open + 1, close, n, soln);
            stack = stack.substring(0, stack.length() - 1);
        }
        if (close < open) {
            stack = stack + ")";
            dfs(stack, open, close + 1, n, soln);
            stack = stack.substring(0, stack.length() - 1);
        }

    }
}
