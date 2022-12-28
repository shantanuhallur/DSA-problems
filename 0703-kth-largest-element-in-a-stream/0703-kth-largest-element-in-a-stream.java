class KthLargest {
    PriorityQueue<Integer> que;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        que = new PriorityQueue<>();
        for(int ele : nums) {
            add(ele);
        }
    }
    
    public int add(int val) {
        que.add(val);
        if(que.size() > k) {
            que.poll();
        }
        return que.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */