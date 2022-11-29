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
    public class BSTpair {
        boolean isBST = true;
        long min = (long)1e13;
        long max = -(long)1e13;
        
        BSTpair(long max,long min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
        
        BSTpair() {
            
        }
    }
    
    public BSTpair isValidBST_01(TreeNode root) {
        if(root == null) return new BSTpair();
        
        BSTpair lans = isValidBST_01(root.left);
        BSTpair rans = isValidBST_01(root.right);
        
        BSTpair myPair = new BSTpair();
        myPair.isBST = lans.isBST && rans.isBST && lans.max < root.val && root.val < rans.min;
        if(!myPair.isBST) return myPair;
        
        myPair.min = Math.min(lans.min,root.val);
        myPair.max = Math.max(rans.max,root.val);
        
        return myPair;
    }
    
    public boolean isValidBST(TreeNode root) {
        BSTpair ans = isValidBST_01(root);
        return ans.isBST;
    }
}