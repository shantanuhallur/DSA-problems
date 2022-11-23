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
    public int[] diameterOfBinaryTree_02(TreeNode root) {
        if(root==null)
            return new int[]{-1,-1};
        int[] leftAns = diameterOfBinaryTree_02(root.left);
        int[] rightAns = diameterOfBinaryTree_02(root.right);
        
        int[] ans = new int[2]; //max(max(leftD,rightD),diameter passing through root).
        ans[0] = Math.max(Math.max(leftAns[0],rightAns[0]),leftAns[1]+rightAns[1]+2); 
        ans[1] = Math.max(leftAns[1],rightAns[1])+1; //max hight from node
        return ans;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;  
        return diameterOfBinaryTree_02(root)[0]; //Return 0th index of Answer.
    }
}