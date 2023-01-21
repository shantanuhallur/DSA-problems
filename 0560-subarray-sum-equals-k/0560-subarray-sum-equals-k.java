class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        int prefSum=0;
        for(int i : nums) {
            prefSum += i;
            ans += map.getOrDefault(prefSum-k,0);
            map.put(prefSum,map.getOrDefault(prefSum,0)+1);
        }
        return ans;
    }
}