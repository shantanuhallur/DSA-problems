/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int getfreq(TreeNode node,HashMap<Integer,Integer> map) {
        if(node == null) return 0;
        
        int leftSum = getfreq(node.left,map);
        int rightSum = getfreq(node.right,map);
        
        int totalSum = leftSum+rightSum+node.val;
        map.put(totalSum,map.getOrDefault(totalSum,0)+1);
        
        return totalSum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        getfreq(root,map);
        
        int maxFreq = -1;
        int count=0;
        for(int value:map.values()) {
            if(maxFreq == value) count++;
            if(maxFreq < value) {
                count=1;
                maxFreq = value;
            }
        }
        System.out.print(count);
        int[] ans = new int[count];
        int i=0;
        for(int key:map.keySet()) {
            if(map.get(key) == maxFreq) ans[i++] = key;
        }
        return ans;
    }
}