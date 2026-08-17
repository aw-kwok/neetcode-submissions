class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        for token in tokens:
            print(stack)
            if is_integer(token):
                stack.append(int(token))
            else:
                num2 = stack.pop()
                num1 = stack.pop()
                match token:
                    case "+":
                        stack.append(num1 + num2)
                    case "-":
                        stack.append(num1 - num2)
                    case "*":
                        stack.append(num1 * num2)
                    case "/":
                        if num1 // num2 < 0 and num1 % num2 != 0:
                            stack.append(num1 // num2 + 1)
                        else:
                            stack.append(num1 // num2)
        return stack[0]
    
def is_integer(val):
    try:
        int(val)
        return True
    except:
        return False