class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()

        curr = intervals[0]
        res = []

        for i in intervals:
            if not curr:
                curr = i
                continue
            if i[0] <= curr[1]:
                curr[1] = max(i[1], curr[1])
            else:
                res.append(curr)
                curr = i
        
        if curr: res.append(curr)

        return res