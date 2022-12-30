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
    public TreeNode removeLeaves(TreeNode root) {
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
            return null;
        }
        
        if(root.left!=null)root.left = removeLeaves(root.left);
        if(root.right!=null)root.right = removeLeaves(root.right);
        
        return root;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        while(true) {
            leaves = new ArrayList<>();
            if(root!=null) {
                root = removeLeaves(root);
            }else break;
            ans.add(leaves);
        }
        return ans;
    }
}