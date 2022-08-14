class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        
        for(int val:nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        
        for(int freq:map.values()){
            if(freq>1)return true;
        }
        return false;
    }
}