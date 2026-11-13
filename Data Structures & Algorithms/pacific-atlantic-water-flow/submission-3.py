class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
        
        def dfs(i, j, ocean, prev_height):
            if i < 0 or i >= len(heights) or j < 0 or j >= len(heights[0]) or heights[i][j] < prev_height or (i, j) in ocean:
                return
            
            ocean.add((i, j))

            for d in directions:
                dfs(i + d[0], j + d[1], ocean, heights[i][j])
            
            return

        # atlantic
        atlantic = set()
        for c in range(len(heights[0])):
            dfs(0, c, atlantic, 0)
        
        for r in range(1, len(heights[0])):
            dfs(r, 0, atlantic, 0)

        # pacific 
        pacific = set()
        for r in range(len(heights)):
            dfs(r, len(heights[0]) - 1, pacific, 0)
        
        for c in range(len(heights[0])):
            dfs(len(heights) - 1, c, pacific, 0)
        
        intersection = atlantic.intersection(pacific)

        return [[i, j] for (i, j) in intersection]