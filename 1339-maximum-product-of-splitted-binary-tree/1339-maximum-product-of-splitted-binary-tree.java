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
    int mod = 1000000007;
    long max = 0;
    long total;
    public int getTotal(TreeNode node) {
        if(node==null) return 0;
        //MODIFYING TREES NODES VAL TO TOTAL VAL OF SUBTREE FOR TRAVERSE FUNCTION
        return node.val+= getTotal(node.left) + getTotal(node.right);
    }
    
    public void traverse(TreeNode node) {
        if(node==null) return;
        traverse(node.left);
        traverse(node.right);
        max = Math.max(node.val*(total-node.val),max);
    }
    public int maxProduct(TreeNode root) {
        this.total = getTotal(root);
        traverse(root);
        return (int)(max%mod);
    }
}