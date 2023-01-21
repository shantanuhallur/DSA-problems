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
    public int getPref(TreeNode node,Long prefSum,int target,HashMap<Long,Integer> map) {
        if(node==null) return 0;
        prefSum+=node.val;
        int res = map.getOrDefault(prefSum-target,0);
        map.put(prefSum,map.getOrDefault(prefSum,0)+1);
        res+= getPref(node.left,prefSum,target,map);
        res+= getPref(node.right,prefSum,target,map);
        map.put(prefSum,map.get(prefSum)-1);
        return res;
    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0l,1);
        return getPref(root,(long)0,targetSum,map);
    }
}