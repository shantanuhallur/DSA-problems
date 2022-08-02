class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean isTrue = true;
        int i=0;
        int j =0;
        Stack<Integer> st = new Stack<>();
        while(i<pushed.length){
            st.push(pushed[i]);
            i++;
            //WHILE is Important as there can be multiple elements that we need to pop.
            while(st.size()>0 && popped[j]==st.peek()){
                st.pop();
                j++;
            }
        }
        //Popping remaining elements. remember to break incase False.
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