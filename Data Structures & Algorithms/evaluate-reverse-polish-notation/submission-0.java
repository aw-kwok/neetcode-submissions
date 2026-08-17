class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (String s : tokens) {
            if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
                stack.push(Integer.valueOf(s));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();
                switch(s) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    default:
                        stack.push(a / b);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
