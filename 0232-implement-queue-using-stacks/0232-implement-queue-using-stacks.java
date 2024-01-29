class MyQueue {
    Stack<Integer> stack;
    public MyQueue() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        
        Stack<Integer> tempStack = new Stack<>();
        
        while(!stack.empty()) {
            tempStack.push(stack.peek());
            stack.pop();
        }
        stack.push(x);
        while(!tempStack.empty()) {
            stack.push(tempStack.peek());
            tempStack.pop();
        }
    }
    
    public int pop() {
        if(stack.size()>0)
        {return stack.pop();}
        return -1;
    }
    
    public int peek() {
        if(stack.size()>0)
            {return stack.peek();}
        return -1;
    }
    
    public boolean empty() {
        return stack.size()==0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */