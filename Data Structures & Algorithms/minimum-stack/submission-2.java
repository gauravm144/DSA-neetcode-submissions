class MinStack {
    Stack<Integer> stk,min_stk;
    public MinStack() {
        stk=new Stack<>();
        min_stk=new Stack<>();
    }
    
    public void push(int val) {
        stk.push(val);
        if(min_stk.isEmpty())
        min_stk.push(val);
        else
        min_stk.push(val<min_stk.peek()?val:min_stk.peek());
    }
    
    public void pop() {
        stk.pop();
        min_stk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min_stk.peek();
    }
}
