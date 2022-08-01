class Solution {
    public int minimumLength(String s) {
        int left=0;
        int right= s.length()-1;
        int ans=0;
        while(left<right && s.charAt(left)==s.charAt(right)){
            char ch = s.charAt(left);
            
            while(left<right && s.charAt(left)== ch){
                left++;
            }
            //LEFT<=RIGHT is important condition here.
            while(left<=right && s.charAt(right)== ch){
                right--;
            }
        }
        return right-left+1;
    }
}