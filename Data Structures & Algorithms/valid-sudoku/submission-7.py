class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for row in board:
            seen = set()
            for num in row:
                if num == ".":
                    continue
                if num in seen:
                    return False
                seen.add(num)

        for c in range(len(board[0])):
            seen = set()
            for r in range(len(board)):
                num = board[r][c]
                if num == ".":
                    continue
                if num in seen:
                    return False
                seen.add(num)
        
        for square in range(9):
            seen = set()
            for i in range(3):
                for j in range(3):
                    r = (square // 3) * 3 + i
                    c = (square % 3) * 3 + j
                    num = board[r][c]
                    if num == ".":
                        continue
                    if num in seen:
                        return False
                    seen.add(num)
        
        return True