class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int count=0;
        int[] odd = new int[n];
        int[] even = new int[n];
        int osum = 0;
        int esum = 0;
        
        for(int i=0;i<n;i++){
            if(i%2==0){
                esum +=nums[i];
            }
            else{
                osum +=nums[i];
            }
            even[i] = esum;
            odd[i] = osum;
        }
        
        for(int i=0;i<n;i++){
            if(i==0){
               int newOdds = even[n-1]-nums[0];
                int newEvens = odd[n-1];
                   if(newOdds==newEvens){
                       count++;
                   }
                continue;
            }

            int newEvens = even[i-1]+ odd[n-1]-odd[i];
            int newOdds = odd[i-1]+  even[n-1]-even[i];
            if(newEvens==newOdds)count++;
        }
        return count;
    }
}