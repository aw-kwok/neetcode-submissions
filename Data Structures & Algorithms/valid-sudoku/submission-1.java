class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check row
        for(int i = 0; i < board.length; i++) {
            HashSet<Character> hs = new HashSet();
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == '.') continue;
                if (hs.contains(board[i][j])) return false;
                hs.add(board[i][j]);
            }
        }
        // check col
        for(int j = 0; j < board[0].length; j++) {
            HashSet<Character> hs = new HashSet();
            for(int i = 0; i < board.length; i++) {
                if(board[i][j] == '.') continue;
                if (hs.contains(board[i][j])) return false;
                hs.add(board[i][j]);
            }
        }

        // check square
        for(int index = 0; index < 9; index++) {
            // 0 1 2
            // 3 4 5
            // 6 7 8

            // (0,0) (0,3) (0,6)
            // (3,0) (3,3) (3,6)
            // (6,0) (6,3) (6,6)

            // row = (index / 3) * 3
            // col = (index % 3) * 3
            int rowStart = (index / 3) * 3;
            int colStart = (index % 3) * 3;
            HashSet<Character> hs = new HashSet();
            for(int i = rowStart; i < rowStart + 3; i++) {
                for(int j = colStart; j < colStart + 3; j++) {
                    if(board[i][j] == '.') continue;
                    if (hs.contains(board[i][j])) return false;
                    hs.add(board[i][j]);
                }
            }

        }

        return true;
    }
}
