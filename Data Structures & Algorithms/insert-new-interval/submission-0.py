class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        curr = newInterval
        for i in intervals:
            if curr[0] > i[1]:
                res.append(i)
            elif curr[1] < i[0]:
                res.append(curr)
                curr = i
            else:
                curr = [min(curr[0], i[0]), max(curr[1], i[1])]
        
        res.append(curr)

        return res