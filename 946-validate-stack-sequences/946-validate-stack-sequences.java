class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean isTrue = true;
        int i=0;
        int j =0;
        Stack<Integer> st = new Stack<>();
        while(i<pushed.length){
            st.push(pushed[i]);
            i++;
            
            while(st.size()>0 && popped[j]==st.peek()){
                st.pop();
                j++;
            }
        }
        
        while(st.size()>0){
            if(popped[j]==st.peek()){
                st.pop();
                j++;
            }
            else{
                isTrue=false;
                break;
            }
        }
        
        return isTrue;
    }
}