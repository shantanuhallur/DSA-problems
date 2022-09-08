class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if(s.length()==0 || s == null)return res;
        
        int[] char_freq = new int[26];
        for(char ch : p.toCharArray()){
            char_freq[ch-'a']++;
        }
        
        int left = 0;
        int right = 0;
        int count = p.length();
        
        while(right<s.length()){
        
            if(char_freq[s.charAt(right++)-'a']-- >= 1) count--;

            if(count == 0)res.add(left);
            
            if(right - left == p.length() && char_freq[s.charAt(left++)-'a']++ >= 0)                    count++;
        }
        return res;
    }
}