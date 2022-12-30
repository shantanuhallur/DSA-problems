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
    int leftChilds = 0;
    int rightChilds = 0;
    int lrc = 0;
    public int countNodes(TreeNode node,int x) {
        if(node == null) return 0;
        int leftCount = countNodes(node.left,x);
        int rightCount = countNodes(node.right,x);
        if(node.val == x) {
            leftChilds = leftCount;
            rightChilds = rightCount;
            lrc = leftCount+rightCount +1;
        }
        return leftCount+rightCount +1;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        countNodes(root,x);
        int totalNodesExcludingX = n - lrc;
        int left = leftChilds;
        int right = rightChilds;
        //number of nodes that can be blocked.
        if(totalNodesExcludingX>n/2 || leftChilds>n/2 || rightChilds>n/2) return true;
        else return false;
    }
}