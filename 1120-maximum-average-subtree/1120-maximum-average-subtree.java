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
    public class pair {
        double sum;
        int totalNodes;
        
        pair(double sum, int totalNodes) {
            this.sum = sum;
            this.totalNodes = totalNodes;
        }
    }
    double maxAvg = 0;
    public pair maxAvg(TreeNode node) { 
        //base case
        if(node == null) return new pair(0,0);
        //left and right right recursive call
        pair leftAns = maxAvg(node.left);
        pair rightAns = maxAvg(node.right);
        //postOrderArea ---->>
        pair myAns = new pair(0,0);
        //total sum of my subtree
        myAns.sum = leftAns.sum + rightAns.sum + node.val;
        //total nodes in my whole subtree
        myAns.totalNodes = leftAns.totalNodes + rightAns.totalNodes + 1;
        //maximuze Avg
        if(myAns.sum/myAns.totalNodes > maxAvg) maxAvg = myAns.sum/myAns.totalNodes;
        
        return myAns;
    }
    
    public double maximumAverageSubtree(TreeNode root) {
        maxAvg(root);
        return maxAvg;
    }
}