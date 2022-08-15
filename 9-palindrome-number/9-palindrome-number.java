class Solution {
    public boolean isPalindrome(int x) {
      int temporary = x;
        int sumation = 0;

        
        while(temporary>0){
            int dig = temporary%10;
            sumation = sumation*10 + dig;
            temporary = temporary/10;
        }
        
        if(sumation==x)return true;
        else return false;
    }
}