class MyQueue {
    private Deque<Integer> s1;
    private Deque<Integer> s2;
    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        moveIfEmpty();
       return s2.pop();
    }
    
    public int peek() {
        moveIfEmpty();
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    public void moveIfEmpty(){
        if(!s2.isEmpty())return;
        
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
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