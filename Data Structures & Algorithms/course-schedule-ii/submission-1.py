class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        adj_list = [[] for i in range(numCourses)]        
        
        for p in prerequisites:
            adj_list[p[0]].append(p[1])

        res = []
        visited = set()
        
        def dfs(i):
            if i in seen:
                return False
            
            if i in visited:
                return True

            seen.add(i)

            for j in adj_list[i]:
                if not dfs(j):
                    return False
            
            res.append(i)
            seen.remove(i)
            visited.add(i)

            return True


        seen = set()

        for i in range(numCourses):
            if i not in seen:
                if not dfs(i):
                    return []
        
        return res
        