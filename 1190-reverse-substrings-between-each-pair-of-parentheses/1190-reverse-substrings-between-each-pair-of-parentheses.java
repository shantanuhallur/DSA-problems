class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            
            if(ch == ')'){
                StringBuilder sb = new StringBuilder();
                while(st.peek()!='('){
                    sb.append(st.pop());
                }
                st.pop();
                System.out.print(sb);
                for(int j=0;j<sb.length();j++){
                    st.push(sb.charAt(j));    
                }
                continue;
            }
            
            st.push(ch);
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