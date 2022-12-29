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
    public int minDepth_01(TreeNode node) {
        //Base Case
        if(node.left == null && node.right ==null) return 1;
        
        int leftMinH = (int)1e6;
        int rightMinH = (int)1e6;
        //Left recursive Call of FAITH
        if(node.left!=null) {
            leftMinH = minDepth_01(node.left);
        }
        //Right recursive call of FAITH
        if(node.right!=null) {
            rightMinH = minDepth_01(node.right);
        }
        
        return Math.min(leftMinH,rightMinH) + 1;
    }
    
    public int minDepth(TreeNode root) {
        //Edge Case
        if(root == null) return 0;
        return minDepth_01(root);
    }
}