class Solution {
    public String longestPalindrome(String s) {
        if(s.length()<1)return "";
        
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length();i++){
            int len1 = expandFromBothSides(s,i,i); // case for racecar (odd)
            int len2 = expandFromBothSides(s,i,i+1); // case for abba   (even)
            
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i - ((len - 1) / 2);
                end   = i +   (len / 2);
            }
        }
        return s.substring(start,end+1);
        
    }
    public int expandFromBothSides(String s,int st ,int e){
        if(st>e || s==null) return 0;
        
        while(st>=0 && e<s.length() && s.charAt(st) == s.charAt(e)){
            st--;
            e++;
        }
        return e-st-1;
    }
}