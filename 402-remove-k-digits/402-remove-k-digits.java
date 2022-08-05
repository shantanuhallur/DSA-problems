class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>st = new Stack<>();
        
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            
            while(st.size()>0 && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        
        while(k>0){
            st.pop();
            k--;
        }
        
        char[] ans = new char[st.size()];
        int j = ans.length-1;
        while(j>=0){
            ans[j--] = st.pop();
        }
        int d = 0;
        while(d<ans.length && ans[d] == '0')d++;
        StringBuilder finalAns = new StringBuilder();
        while(d<ans.length) finalAns.append(ans[d++]);
        if(finalAns.length()==0) finalAns.append('0');
        return finalAns.toString();
    }
}