class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i=0;
        Stack<Integer> st = new Stack<>();

        for(int val:pushed){
            st.push(val);
            while(st.size()>0 && st.peek()==popped[i]){
                st.pop();
                i++;
            }
        }
        return i==popped.length;
    }
}