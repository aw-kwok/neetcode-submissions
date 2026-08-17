class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> soln = new ArrayList<>();
        String stack = "";
        int l = 0;
        int r = 0;
        dfs(n, stack, soln, 0, 0);
        return soln;
    }
    public void dfs(int n, String stack, List<String> soln, int l, int r) {
        if ((l + r) == 2 * n) {
            soln.add(stack);
            return;
        }
        if (l < n) {
            stack = stack + "(";
            dfs(n, stack, soln, l + 1, r);
            stack = stack.substring(0, stack.length() - 1);
        }
        if (r < l) {
            stack = stack + ")";
            dfs(n, stack, soln, l, r + 1);
            stack = stack.substring(0, stack.length() - 1);
        }
    }
}
