class Solution {
    private int[][] directions = {{1, 0},  {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // oceans will be [pacific, atlantic]
        List<List<Integer>> soln = new ArrayList<>();
        for (int r = 0; r < heights.length; r++) {
            for (int c = 0; c < heights[0].length; c++) {
                boolean[] oceans = new boolean[2];
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                dfs(heights, r, c, Integer.MAX_VALUE, oceans, visited);
                if (oceans[0] && oceans[1]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(r);
                    cell.add(c);
                    soln.add(cell);
                }
            }
        }
        return soln;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight, boolean[] oceans, boolean[][] visited) {
        if (r >= heights.length || c >= heights[0].length) {
            oceans[1] = true;
            return;
        }
        if (r < 0 || c < 0) {
            oceans[0] = true;
            return;
        }

        if (visited[r][c]) return;
        if (heights[r][c] > prevHeight) return;

        visited[r][c] = true;
        
        for (int[] directions : directions) {
            dfs(heights, r + directions[0], c + directions[1], heights[r][c], oceans, visited);
        }
    }
}
