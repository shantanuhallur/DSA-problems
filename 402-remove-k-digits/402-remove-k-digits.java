class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>st = new Stack<>();
        // start removing elements from MSB. 
        //Remove MSB is larger than num to its right which will take its place.
        for(int i=0;i<num.length();i++){
            char ch = num.charAt(i);
            
            while(st.size()>0 && k>0 && st.peek()>ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        // if k is still left we should start removing from last.
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