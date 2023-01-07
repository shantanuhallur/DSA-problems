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
    double maxAvg = -1;
    public class pair {
        int numN =0;
        double sum = 0;
        pair(int numN,double sum){
            this.numN = numN;
            this.sum = sum;
        }
    }
    public pair avge(TreeNode node) {
        if(node==null) return new pair(0,0);
        
        pair leftavg = avge(node.left);
        pair rightavg = avge(node.right);
        pair myavg = new pair(0,0);
        
        myavg.sum =  leftavg.sum+rightavg.sum + node.val;
        myavg.numN = leftavg.numN + rightavg.numN + 1;
        if(myavg.sum/myavg.numN > maxAvg) maxAvg = myavg.sum/myavg.numN;
        return myavg;
    }
    public double maximumAverageSubtree(TreeNode root) {
        pair ans = avge(root);
        return maxAvg;
    }
}