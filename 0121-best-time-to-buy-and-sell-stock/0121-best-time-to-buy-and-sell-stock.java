class Solution {
    public int maxProfit(int[] prices) {
     int sum = 0;
       
        int max = prices[prices.length-1];
        
        for(int i=prices.length-2;i>=0;i--){
           if(max - prices[i] > sum){
               sum = max - prices[i] ;
           }
            max = Math.max(max,prices[i]);
        }
        
        return sum;
    }
}