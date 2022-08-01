class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j= s.length()-1;
        int ans=0;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                char temp = s.charAt(i);
                while(i < s.length() && s.charAt(i)==temp){
                    i++;
                }
                while(j >=0  && s.charAt(j)==temp){
                    j--;
                }
            }
            else{
                 
                break;
            }
        }
        if(i>j){
            return 0;
        }
        else{
            ans = j-i+1;
            return ans;
        }
    }
}