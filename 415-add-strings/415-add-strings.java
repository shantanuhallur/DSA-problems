class Solution {
    public String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length()-1;
        int j = num2.length()-1;
        String ans = "";
        while(i>=0 || j >=0 || carry!=0){
          int ival = i>=0 ? num1.charAt(i)-'0':0;
          int jval = j>=0 ? num2.charAt(j)-'0':0;
            
            int sum = ival+jval+carry;
            
            int dig = sum%10;
            carry = sum/10;
            
            ans = dig+ans;
            
            i--;
            j--;
        }
        return ans;
    }
}