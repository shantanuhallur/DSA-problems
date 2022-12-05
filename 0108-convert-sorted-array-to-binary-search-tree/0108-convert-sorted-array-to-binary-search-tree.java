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
    public TreeNode sortedArrayToBST_01(int[] nums,int si,int ei) { 
        if(si>ei) return null;
        
        int mid = (si+ei)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST_01(nums,si,mid-1);
        node.right = sortedArrayToBST_01(nums,mid+1,ei);
        
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return new TreeNode();
        int si = 0;
        int ei = nums.length-1;
        return sortedArrayToBST_01(nums,si,ei);
    }
}