class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                Queue<Character> q = new LinkedList();
                while(st.peek()!='('){
                    q.add(st.pop());
                }
                st.pop();
               while(q.size()>0){
                   st.push(q.remove());
               }
            }
           else st.push(s.charAt(i));
        }
        
        char[] ans = new char[st.size()];
        int k = st.size()-1;
        while(st.size()>0){
            ans[k--] = st.pop();    
        }
        
        String finalAns = String.valueOf(ans);
        
        return finalAns;
    }
}