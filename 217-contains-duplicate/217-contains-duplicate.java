class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer>nos = new HashSet<>();
        
        for(int val:nums){
            if(nos.contains(val))return true;
            nos.add(val);
        }
        return false;
    }
}