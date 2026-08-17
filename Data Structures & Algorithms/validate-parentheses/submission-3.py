class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for _, c in enumerate(s):
            print(c)
            match c:
                case "(" | "{" | "[":
                    stack.append(c)
                case ")":
                    if not stack or stack.pop() != "(":
                        return False
                case "}":
                    if not stack or stack.pop() != "{":
                        return False
                case "]":
                    if not stack or stack.pop() != "[":
                        return False
                case "_":
                    return False
        return not stack    