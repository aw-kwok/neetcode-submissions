class Solution {
    public static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(dfs(grid, i, j), max);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || 
            j < 0 || j > grid[0].length - 1 || 
            grid[i][j] == 0) return 0;

        grid[i][j] = 0;

        int size = 0;
        for (int[] direction : directions) {
            size += dfs(grid, i + direction[0], j + direction[1]);
        }
        return size + 1;
    }
}
