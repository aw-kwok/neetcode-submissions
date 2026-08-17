class Solution {
    private int[][] directions = {{1, 0},  {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][] atlantic = new boolean[ROWS][COLS];
        boolean[][] pacific = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            dfs(heights, r, 0, pacific);
            dfs(heights, r, COLS - 1, atlantic);
        }

        for (int c = 0; c < COLS; c++) {
            dfs(heights, 0, c, pacific);
            dfs(heights, ROWS - 1, c, atlantic);
        }

        List<List<Integer>> soln = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if(atlantic[r][c] && pacific[r][c]) soln.add(Arrays.asList(r, c));
            }
        }
        return soln;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] ocean) {
        ocean[r][c] = true;

        for (int[] directions : directions) {
            int nr = r + directions[0];
            int nc = c + directions[1];
            if (nr >= 0 && nr < heights.length &&
                nc >= 0 && nc < heights[0].length &&
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, ocean);
            }
        }
    }
}
