class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        Stack<Character> stack = new Stack<>();
        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(r, c, board, word, stack, seen)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, char[][] board, String word, Stack<Character> stack, boolean[][] seen) {
        if (r < 0 || r >= board.length ||
            c < 0 || c >= board[0].length ||
            seen[r][c] == true
        ) return false;

        seen[r][c] = true;
        stack.push(board[r][c]);

        if (word.length() == stack.size()) {
            List<Character> list = new ArrayList<>(stack);
            String newWord = list.stream().map(String::valueOf).collect(Collectors.joining());
            System.out.println();
            if (word.equals(newWord)) return true;
        }

        for (int[] direction : directions) {
            int nr = r + direction[0];
            int nc = c + direction[1];
            if (dfs(nr, nc, board, word, stack, seen)) return true;
        }
        stack.pop();
        seen[r][c] = false;
        return false;
    }
}
