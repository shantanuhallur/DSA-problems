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
    public TreeNode makeBST(int[] nums,int st,int end) {
        if(st>end) return null;
        int maxNo = -1;
        int midIdx = -1;
        
        for(int i=st;i<=end;i++) {
            if(nums[i]>maxNo) {
                maxNo = nums[i];
                midIdx = i;
            }
        }
        
        TreeNode root = new TreeNode(nums[midIdx]);
        root.left = makeBST(nums,st,midIdx-1);
        root.right = makeBST(nums,midIdx+1,end);
        
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return makeBST(nums,0,nums.length-1);
    }
}