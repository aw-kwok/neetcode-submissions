class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = []
        res = [0] * len(temperatures)
        for i, temp in enumerate(temperatures):
            while stack and temp > stack[-1][0]:
                past_temp = stack.pop()[1]
                res[past_temp] = i - past_temp
            stack.append((temp, i))
        return res