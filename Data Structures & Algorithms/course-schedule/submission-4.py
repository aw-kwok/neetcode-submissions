class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        adj_list = [[] for i in range(numCourses)]        
        
        for p in prerequisites:
            adj_list[p[0]].append(p[1])
        
        def dfs(i):
            if i in seen:
                return False

            seen.add(i)

            for j in adj_list[i]:
                if not dfs(j):
                    return False
            
            seen.remove(i)
            adj_list[i] = []

            return True


        seen = set()

        for i in range(numCourses):
            if i not in seen:
                if not dfs(i):
                    return False
        
        return True
        