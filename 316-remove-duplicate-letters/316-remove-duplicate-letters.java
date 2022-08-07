class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character>st = new Stack<>();
        int[] freq = new int[26];
        boolean[] exist = new boolean[26];
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']--; // 1) remove count.
            if(exist[ch-'a'])continue; //2) check if exists
            
            while(st.size()>0 && st.peek()> ch && freq[st.peek() -'a']>0){
                exist[st.peek()-'a'] = false;
                st.pop();
                
            }
            st.push(ch);
            exist[ch-'a'] = true;
        }
        
        char[] arr = new char[st.size()];
        int j = arr.length-1;
        while(j>=0){
            arr[j--] = st.pop();
        }
        
        return new String(arr);
    }
}