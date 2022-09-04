class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int i =0;
        int factor = 1;
        int[] res = new int[num_people];
        
        while(candies>0){
            if(candies>=factor){
                res[i] += factor;
                candies = candies - factor;
            }
            else{
                res[i] += candies;
                candies = candies - candies;
            }
            i++;
            factor++;
            if(i==num_people)i=0;
        }
        return res;
    }
}