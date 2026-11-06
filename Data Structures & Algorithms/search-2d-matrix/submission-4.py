class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        u, d = 0, len(matrix) - 1
        
        row = -1
        while u <= d:
            row = (u + d) // 2
            if target >= matrix[row][0] and target <= matrix[row][len(matrix[0]) - 1]:
                break
            elif target < matrix[row][0]:
                d = row - 1
            else:
                u = row + 1
        
        if row < 0 or row >= len(matrix):
            return False
        
        l, r = 0, len(matrix[0]) - 1
        while l <= r:
            m = (l + r) // 2
            if target == matrix[row][m]:
                return True
            elif target > matrix[row][m]:
                l = m + 1
            else:
                r = m - 1
        return False