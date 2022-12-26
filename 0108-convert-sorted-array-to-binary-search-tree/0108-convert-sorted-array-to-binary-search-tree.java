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
    public TreeNode makeBST(int[] nums,int si,int ei) {
        //Base case.
        if(si>ei) return null;
        //Calculate Mid.
        int mid = (si+ei)/2;
        TreeNode root = new TreeNode(nums[mid]);
        //Capture left subtree & right subtree through recursive calls
        root.left = makeBST(nums,si,mid-1);
        root.right = makeBST(nums,mid+1,ei);
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums,0,nums.length-1);
    }
}