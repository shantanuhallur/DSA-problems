class Solution {
    public int[] plusOne(int[] digits) {
       // StringBuilder ans = new StringBuilder();
        String ans="";
        int carry=1;
        
        int i=digits.length-1;
        while(i>=0){
            int no = digits[i]+carry;
            carry = no/10;
            int digit = no%10;
            ans = digit + ans;
            i--;
        }
       if(carry>0) ans = carry + ans;
       int[] res = new int[ans.length()];
        for(int j=ans.length()-1;j>=0;j--)res[j]=ans.charAt(j)-'0';
        return res;
    }
}