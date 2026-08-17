class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        close_to_open = { ")" : "(", "]" : "[",  "}" : "{"}
        for c in s:
            if c in close_to_open:
                if stack and stack.pop() == close_to_open[c]:
                    continue
                else:
                    return False
            else:
                stack.append(c)
        return not stack
