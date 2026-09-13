class MinStack {
public  Stack<Integer> dataStack = null;
    public  Stack<Integer> minStack = null;
    public MinStack() {
      dataStack = new Stack<>();
        minStack  = new Stack<>();  
    }
    
    public void push(int val) {
        dataStack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        } else if (val < minStack.peek()) {
            minStack.push(val);
        }else{
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        dataStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
         return minStack.peek();
    }
}
