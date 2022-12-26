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
    int totalGoodNodes = 0;
    
    public void goodNodes_01(TreeNode root,int maxVal) {
        if(root==null) return;
        
        if(root.val >= maxVal) {
            totalGoodNodes++;
            maxVal = root.val;
        }
        
        goodNodes_01(root.left,maxVal);
        goodNodes_01(root.right,maxVal);
    }  
    
    public int goodNodes(TreeNode root) {
        goodNodes_01(root,-(int)1e8);
        return totalGoodNodes;
    }
}