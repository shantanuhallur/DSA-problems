class Solution {
    public int[] asteroidCollision(int[] asteroids) {
              boolean posFound = true;
        Stack<Integer> st = new Stack<>();
  
     for(int val:asteroids){
         if(val >0){
             st.push(val);
         }
         else{
             while(st.size()>0 && st.peek()> 0 && st.peek()<-val){
                 st.pop();
             }
             if(st.size()>0 && st.peek() == -val){
                 st.pop();
             }
             else if(st.size()>0 && st.peek()> -val){
                 
             }
             else{
                 st.push(val);
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