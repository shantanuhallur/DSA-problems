class Solution {
    public int thirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        
        for(Integer val :nums){
            if(val.equals(firstMax) ||val.equals(secondMax)||val.equals(thirdMax))continue;
            
            if(firstMax == null || val>firstMax){
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = val;
            }
            else if(secondMax == null ||val>secondMax && val<firstMax){
                thirdMax = secondMax;
                secondMax = val;
            }
            else if(thirdMax == null || val>thirdMax && val<secondMax){
                thirdMax = val;
            }
        }
        return thirdMax==null?firstMax:thirdMax;
    }
}