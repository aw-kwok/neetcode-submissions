class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int row = 0; row < board.length; row++) {
            Set<Character> hs = new HashSet<>();
            for (int i = 0; i < board[row].length; i++) {
                if (board[row][i] == '.') continue;
                if (hs.contains(board[row][i])) {
                    return false;
                }
                hs.add(board[row][i]);
            }
        }
        
        //check cols
        for (int col = 0; col < board[0].length; col++) {
            Set<Character> hs = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] == '.') continue;
                if (hs.contains(board[i][col])) {
                    return false;
                }
                hs.add(board[i][col]);
            }
        }

        //check squares

        for (int square = 0; square < 9; square++) {
            Set<Character> hs = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (hs.contains(board[row][col])) return false;
                    hs.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
