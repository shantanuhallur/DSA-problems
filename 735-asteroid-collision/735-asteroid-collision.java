class Solution {
    public int[] asteroidCollision(int[] asteroids) {
              boolean posFound = true;
        Stack<Integer> st = new Stack<>();
  
     for(int val:asteroids){
         if(val >0){
             st.push(val);
             //positive push.
         }
         else{
             while(st.size()>0 && st.peek()> 0 && st.peek()<-val){
                 st.pop(); // if peek is positive and has smaller value than negative asteroid[val];
             }
             if(st.size()>0 && st.peek() == -val){
                 st.pop(); // if peek is positive and has same value as negative asteroid[val];
             }
             else if(st.size()>0 && st.peek()> -val){
                 // if peek is positive and has larger value as negative asteroid[val];
             }
             else{
                 st.push(val); // push negative val in any way. peek already has negative or all values are popped and remaining is only this asteroids[val] largest value. 
             }
         }
     }
        
        int[] ans = new int[st.size()];
        int j= ans.length-1;
        while(j>=0){
            ans[j] = st.pop();
            j--;
        }
        
        return ans;
    }
}