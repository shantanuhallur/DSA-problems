class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] check_arr = new int[s.length()];
        int curr_dist = -100001;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==c){
                curr_dist = i;
            }
            check_arr[i] = i - curr_dist;
        }
       
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==c){
                curr_dist=i;
            }
            check_arr[i] = Math.min(check_arr[i],Math.abs(i-curr_dist));
        }
        return check_arr;
    }
}