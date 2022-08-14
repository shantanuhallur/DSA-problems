class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(numbers[i])){
                int[] ans = new int[2];
                ans[0] = map.get(numbers[i]) +1;
                ans[1] = i+1;
                return ans;
            }
            map.put(target-numbers[i],i);
        }
        
        return new int[2];
    }
    
}