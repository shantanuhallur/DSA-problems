class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++){
        // ONE AND ONLYY CONDITION WHEN WE WILL POP FROM STACK AND SKIP ITERATION.
           if(st.size()>0 && st.peek()=='(' && s.charAt(i)==')'){
               st.pop();
               continue;
           }
        //ELSE WE WILL JUST KEEP PUSHING INTO STACK.    
            st.push(s.charAt(i));
        }
        return st.size();
    }
}