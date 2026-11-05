class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in board:
            seen = set()
            for c in row:
                if c == ".":
                    continue
                if c in seen:
                    return False
                seen.add(c)
        
        for i in range(len(board[0])):
            seen = set()
            for j in range(len(board)):
                c = board[j][i]
                if c == ".":
                    continue
                if c in seen:
                    return False
                seen.add(c)
        
        for i in range(len(board)):
            #0,0 0,1 0,2 1,0 1,1 1,2
            seen = set()
            r = 3 * (i // 3)
            c = 3 * (i % 3)
            for j in range(3):
                for k in range(3):
                    n = board[r + j][c + k]
                    if n == ".":
                        continue
                    if n in seen:
                        return False
                    seen.add(n)
        
        return True
                