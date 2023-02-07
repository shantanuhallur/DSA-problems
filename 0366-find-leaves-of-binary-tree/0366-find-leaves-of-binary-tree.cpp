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
    List<Integer> leaves;
    public TreeNode removeLeaves(TreeNode node) {
        //Base condition for leaf
        if(node.left==null && node.right == null) {
            leaves.add(node.val);
            return null;
        }
        
        //Left & Right recursive call
        if(node.left!=null)node.left = removeLeaves(node.left);
        if(node.right!=null)node.right = removeLeaves(node.right);
        
        return node;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        while(true) {
            leaves = new ArrayList<>();
            //if tree exists
            if(root!=null) {
                root = removeLeaves(root);
            }
            //Tree has finished removing every level
            else break;
            ans.add(leaves);
        }
        return ans;
    }
}