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
    public void goodNodes_01(TreeNode node,int maxVal) {
        //Base Case
        if(node==null)return;
        // Checking if current node is a good node or not
        if(node.val >= maxVal) {
            totalGoodNodes++;
            maxVal = node.val;
        }
        
        //Left and right recursive call for traversing the tree.
        goodNodes_01(node.left,maxVal);
        goodNodes_01(node.right,maxVal);
        
    }
    
    public int goodNodes(TreeNode root) {
        goodNodes_01(root,-(int)1e5);
        return totalGoodNodes;
    }
}