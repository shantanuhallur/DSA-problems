class Solution {
    public int maxProfit(int[] prices) {
     int sum = 0;
        int[] lrarr = new int[prices.length];
        int max = prices[lrarr.length-1];
        lrarr[lrarr.length-1] = -1;
        for(int i=lrarr.length-2;i>=0;i--){
            lrarr[i] = prices[i]>max?-1:max;
            max = Math.max(max,prices[i]);
        }
        
        for(int i=0;i<lrarr.length;i++){
            if(lrarr[i]!=-1){
                sum = Math.max(sum,lrarr[i]-prices[i]);
            }
        }
        return sum;
    }
}