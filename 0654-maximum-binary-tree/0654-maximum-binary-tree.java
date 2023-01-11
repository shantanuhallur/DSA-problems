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
    public TreeNode buildBST(int[] nums,int st,int end) {
        //Base Case
        if(st>end) return null;
        //get idx of max element in range st->end in nums
        int idx = -1;
        int maxEle = -1;
        for(int i=st;i<=end;i++) {
            if(nums[i]> maxEle) {
                idx = i;
                maxEle = nums[i];
            }
        }
        //Create a root node
        TreeNode root = new TreeNode(nums[idx]);
        //pass left and right recursive calls like step 2 and 3 in algorithm
        root.left = buildBST(nums,st,idx-1);
        root.right = buildBST(nums,idx+1, end);
        
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildBST(nums,0,nums.length-1);
    }
}