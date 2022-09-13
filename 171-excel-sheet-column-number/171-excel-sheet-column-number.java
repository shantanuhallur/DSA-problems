class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int pow = 0;
        int ans = 0;
       
        for(int i=n-1;i>=0;i--){
            char ch = columnTitle.charAt(i);
            int num = (ch - 'A') +1;
            ans += (int)Math.pow(26,pow)*num;
            pow++;
        }
      return ans;
    
    }
}