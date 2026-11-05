class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        begin_to_end = {'(': ')', '[': ']', '{': '}'}

        for c in s:
            if c in begin_to_end:
                stack.append(begin_to_end[c])
            else:
                if not stack or c != stack.pop():
                    return False
        
        return not stack