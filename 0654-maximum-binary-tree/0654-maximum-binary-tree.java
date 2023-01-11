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
    TreeNode buildBST(int[] nums, int st, int end) {
        if(st>end) return null;
        
        int idx = -1;
        int maxNo = -1;
        for(int i=st ; i<=end; i++) {
            if(nums[i] > maxNo) {
                idx = i;
                maxNo = nums[i];
            }
        }
        
        TreeNode root = new TreeNode(nums[idx]);
        
        root.left = buildBST(nums,st,idx-1);
        root.right = buildBST(nums,idx+1,end);
        
        return root;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }
}