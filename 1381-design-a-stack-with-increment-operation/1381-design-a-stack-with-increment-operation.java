class CustomStack {
    int[] value;
    int[] increment;
    int idx;
    public CustomStack(int maxSize) {
        value = new int[maxSize];
        increment = new int[maxSize];
        idx = -1;
    }
    
    public void push(int x) {
        if(idx +1 == value.length){
            return;
        }
        idx++;
        value[idx] = x;
        increment[idx] = 0;
    }
    
    public int pop() {
        if(idx== -1){
            return -1;
        }
        int x = value[idx];
        int inc = increment[idx];
        idx--;
        
        if(idx>=0){
            increment[idx] += inc;
        }
        
        return x+inc;
    }
    
    public void increment(int k, int val) {
        int ind = Math.min(k-1,idx);
        if(idx>=0)increment[ind] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */