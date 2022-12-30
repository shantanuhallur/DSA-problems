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
    int xLeftCount = 0;
    int xRightCount = 0;
    int countNodes(TreeNode node, int x) {
        //Base Case
        if(node==null) return 0;
        //Left and Right Node recursive calls
        int leftCount = countNodes(node.left,x);
        int rightCount = countNodes(node.right,x);
        //check if current node is the node of which we want to find leftC & rightC
        if(node.val == x) {
            xLeftCount = leftCount;
            xRightCount = rightCount;
        }
        
        return leftCount+rightCount+1;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        countNodes(root,x);
        int remainingNodesCount = n - (xLeftCount+xRightCount+1);
        
        if(xLeftCount > n/2 || xRightCount > n/2 || remainingNodesCount > n/2) return true;
        else return false;
    }
}