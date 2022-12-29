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
        int sum = 0;
        int nodeCount=0;
        pair(int sum,int nodeCount) {
            this.sum = sum;
            this.nodeCount = nodeCount;
        }
        pair(){}
    }
    int avgNodeCount=0;
    public pair averageOfSubtree_01(TreeNode node) {
        if(node.left ==null && node.right == null) {
            avgNodeCount++;
            return new pair(node.val,1);
        }
        
        pair leftP = new pair();
        pair rightP = new pair();
        pair myPair = new pair();
        
        if(node.left != null) leftP = averageOfSubtree_01(node.left);
        if(node.right!= null) rightP = averageOfSubtree_01(node.right);
        
        myPair.sum = leftP.sum + rightP.sum + node.val;
        myPair.nodeCount = leftP.nodeCount + rightP.nodeCount +1;
        
        if(myPair.sum / myPair.nodeCount == node.val) avgNodeCount++;
        
        return myPair;
    }
    
    public int averageOfSubtree(TreeNode root) {
        averageOfSubtree_01(root);
        return avgNodeCount;
    }
}