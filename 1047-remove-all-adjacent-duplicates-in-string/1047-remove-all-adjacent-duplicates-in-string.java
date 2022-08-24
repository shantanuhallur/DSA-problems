class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        int i=0;
        
        while(i<s.length()){
            if(st.size()>0 && st.peek() == s.charAt(i)){
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
            i++;
        }
        
        char[] ans = new char[st.size()];
        int j = ans.length-1;
        while(j>=0){
            ans[j--] = st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        for(int k =0;k<ans.length;k++){
            sb.append(ans[k]);
        }
        return sb.toString();
    }
}