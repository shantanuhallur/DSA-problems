class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] carr = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ')'){
                if(st.size()>0 && s.charAt(st.peek())=='('){
                        st.pop();
                   }
                else{
                    st.push(i);
                }
            }
            else if(s.charAt(i)=='('){
                st.push(i);
            }
        }
        
        while(st.size()>0){
            carr[st.pop()] = '@';
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<carr.length;i++){
            if(carr[i]!='@'){
                sb.append(carr[i]);
            }
        }
        
        return String.valueOf(sb);
    }
}