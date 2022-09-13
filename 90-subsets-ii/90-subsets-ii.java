class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;
    }
    
    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (!result.contains(current)) result.add(new ArrayList<>(current)); // n

        for (int i = index; i < nums.length; i++) { // 2 ^ n
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}