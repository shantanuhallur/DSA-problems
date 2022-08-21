class NumArray {
   //Beautifully taught FJP DSA Lecture of 20th August 2022
    class Fenwick{
        int[] farr;
        
        Fenwick(int[]nums){
            this.farr = new int[nums.length + 1]; //Main initial initializations done in                            NumArray function. (Main work of the Constructor)
        }
        
       int sum(int pos){
           int sum = 0;
            while(pos>0){
                sum += farr[pos];
               pos = pos - rsb(pos);
            }
           return sum;
        }
        
        void update(int pos ,int delta){
            while(pos<farr.length){
                farr[pos] = farr[pos]+delta;
                pos = pos + rsb(pos);
            } 
        }
        
        private int rsb(int x){
            return x & -x;
        }
    }
    Fenwick ft;
    int[] oarr;
    public NumArray(int[] nums) {
        ft = new Fenwick(nums);
        oarr = nums;
        for(int i=0;i<nums.length;i++){
            int pos = i+1;
            int val = nums[i]; //Original values of nums is the delta as the Fenwick        Tree while first initializations is empty hence the values of nums are itself the         deltas.
            ft.update(pos,val);
        }
    }
    
    public void update(int index, int val) {
        int delta = val - oarr[index];
        int pos = index+1; //Fenwick based position;
        ft.update(pos,delta); //updating fenwick array as well.
        oarr[index] = val; //updating original array as well.
        
    }
    
    public int sumRange(int left, int right) {
        // left right are 0 based indexes , positions in fenwick tree are 1 based as 0              doesnt store anything in a fenwick Tree.
        int lpos = left+1;
        int rpos = right+1;
        
        int zeroToLMinus1sum = ft.sum(lpos-1); //sum from 1 minus that position
        int zeroToRsum = ft.sum(rpos);   //sum till that right position
        
        return zeroToRsum-zeroToLMinus1sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */