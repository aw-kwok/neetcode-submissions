class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        int r = m - 1;
        int c = n - 1;
        queue.offer(new int[]{r, c});
        dp[r][c] = 1;
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            r = cell[0];
            c = cell[1];
            
            if (r - 1 >= 0 && dp[r - 1][c] == 0) queue.offer(new int[]{r - 1, c});
            if (c - 1 >= 0 && dp[r][c - 1] == 0) queue.offer(new int[]{r, c - 1});

            int right = c + 1 < n ? dp[r][c + 1] : 0;
            int down = r + 1 < m ? dp[r + 1][c] : 0;
            
            dp[r][c] = r == m - 1 && c == n - 1 ? 1 : right + down;
        }

        return dp[0][0];
    }
}
