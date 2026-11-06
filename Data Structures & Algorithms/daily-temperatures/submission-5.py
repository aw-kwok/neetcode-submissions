class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        stack = [] # (t, idx)

        for i, t in enumerate(temperatures):
            while stack and stack[-1][0] < t:
                _, old_i = stack.pop()
                res[old_i] = i - old_i
            stack.append((t, i))

        return res                