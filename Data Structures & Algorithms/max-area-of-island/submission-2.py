class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        max_area = 0

        def dfs(grid, r, c):
            if r < 0 or r >= len(grid) or c < 0 or c >= len(grid[0]) or grid[r][c] == 0:
                return 0
            
            grid[r][c] = 0

            island_area = 1
            for d in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                r_, c_ = d
                island_area += dfs(grid, r + r_, c + c_)
            
            return island_area
        
        for r in range(len(grid)):
            for c in range(len(grid[0])):
                if grid[r][c] == 1:
                    max_area = max(max_area, dfs(grid, r, c))
        
        return max_area