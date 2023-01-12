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
    double maxAvg = 0;
    public class pair{
        double sum;
        int totalNodes;
        
        pair(double sum,int totalNodes) {
            this.sum = sum;
            this.totalNodes = totalNodes;
        }
    }
    public pair getMax(TreeNode node) {
        if(node==null) return new pair(0,0);
        
        pair leftAns = getMax(node.left);
        pair rightAns = getMax(node.right);
        
        pair myAns = new pair(0,0);
        myAns.sum = leftAns.sum + rightAns.sum + node.val;
        myAns.totalNodes = leftAns.totalNodes + rightAns.totalNodes + 1;
        if(myAns.sum/myAns.totalNodes > maxAvg) maxAvg = myAns.sum/myAns.totalNodes;
        
        return myAns;
        
    }
    public double maximumAverageSubtree(TreeNode root) {
        getMax(root);
        return maxAvg;
    }
}