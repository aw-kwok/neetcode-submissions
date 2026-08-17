class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        u, d = 0, len(matrix) - 1
        mid_row = None
        while u <= d:
            mid_row = (u + d) // 2
            if target >= matrix[mid_row][0] and target <= matrix[mid_row][len(matrix[mid_row]) - 1]:
                break
            elif target < matrix[mid_row][0]:
                d = mid_row - 1
            else:
                u = mid_row + 1
        
        row = matrix[mid_row]

        l, r = 0, len(matrix[mid_row]) - 1
        while l <= r:
            mid = (l + r) // 2
            if target > row[mid]:
                l = mid + 1
            elif target < row[mid]:
                r = mid - 1
            else:
                return True
        
        return False