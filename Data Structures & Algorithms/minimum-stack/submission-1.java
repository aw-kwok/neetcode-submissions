class MinStack {

    Stack<Integer> stack;
    Stack<Integer> mins;

    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
        System.out.println("Stack created");
    }
    
    public void push(int val) {
        stack.push(val);
        if (!mins.isEmpty()) mins.push(Math.min(mins.peek(), val));
        else mins.push(val);
        
    }
    
    public void pop() {
        stack.pop();
        mins.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}
