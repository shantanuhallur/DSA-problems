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
    int leftNCounts = 0;
    int rightNCounts = 0;
    int lrSum = 0;
    public int countNodes(TreeNode node,int x) {
        //Base Case
        if(node==null) return 0;
        //left right recursive call
        int leftN = countNodes(node.left,x);
        int rightN = countNodes(node.right,x);
        
        if(node.val == x) {
            leftNCounts = leftN;
            rightNCounts = rightN;
            lrSum = leftN+rightN +1;
        }
      return leftN+rightN+1;  
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        countNodes(root,x);
        
        if(leftNCounts>n/2 || rightNCounts>n/2 || n-lrSum>n/2)return true;
        else return false;
    }
}