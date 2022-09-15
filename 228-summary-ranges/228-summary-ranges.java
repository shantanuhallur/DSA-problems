class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length==0)return new ArrayList<>();
        
        List<String> ranges = new ArrayList<>();
        int start = nums[0];
        for(int i=0;i<nums.length;i++){
            if(i==nums.length-1 || nums[i]+1 != nums[i+1]){
                ranges.add(encode(start,nums[i]));
                
                if(i!= nums.length-1)start = nums[i+1];
            }
        }
        return ranges;
    }
    public String encode(int start , int end){
        StringBuilder range = new StringBuilder();
        if(start==end){
            range.append(start);
        }
        else{
            range.append(start)
                  .append("->")
                  .append(end);
        }
        return range.toString();
    }
}