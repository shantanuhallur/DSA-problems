class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1=1,c2=0;
        int val1 = nums[0] , val2 = nums[0];
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]==val1){
                c1++;
            }
            else if(nums[i]==val2){
                c2++;
            }
            else{
                if(c1==0){
                    val1=nums[i];
                    c1=1;
                }
                else if(c2==0){
                    val2=nums[i];
                    c2=1;
                }
                else{
                    c1--;c2--;
                }
            }
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        if(isGreaterN3(val1,nums)){
            res.add(val1);
        }
        if(isGreaterN3(val2,nums) && val1!=val2){
            res.add(val2);
        }
        
        return res;
    }
    public boolean isGreaterN3(int no,int[] nums){
        int count = 0;
        int size = nums.length;
        for(int i=0;i<size;i++){
            if(nums[i]==no){
                count++;
            }
        }
        if(count>size/3){
            return true;
        }
        else{
            return false;
        }
    }
}