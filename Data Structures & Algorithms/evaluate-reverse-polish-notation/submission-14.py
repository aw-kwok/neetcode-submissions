class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        operations = set(["+", "-", "*", "/"])

        for token in tokens:
            if token not in operations:
                stack.append(int(token))
            else:
                a, b = stack.pop(), stack.pop()
                
                match token:
                    case "+":
                        stack.append(a + b)
                    case "-":
                        stack.append(b - a)
                    case "*":
                        stack.append(a * b)
                    case "/":
                        stack.append(int(float(b) / a))
            
        return stack[0]