class MyStack {
    private Queue<Integer>q;
    public MyStack() {
        this.q = new LinkedList<>();        
    }
    
    public void push(int x) {
        this.q.add(x);
        this.rotate();
    }
    
    public int pop() {
        return this.q.poll();
    }
    
    public int top() {
        return this.q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
    
    private void rotate(){
        int n = q.size();
        while(n-1!=0){
            q.add(q.poll());
            n--;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */