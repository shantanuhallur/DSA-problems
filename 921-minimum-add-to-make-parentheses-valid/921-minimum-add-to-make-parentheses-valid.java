class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
           if(st.size()>0 && st.peek()=='(' && s.charAt(i)==')'){
               st.pop();
               continue;
           }
            
            st.push(s.charAt(i));
        }
        return st.size();
    }
}