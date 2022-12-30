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
    List<Integer> smallAns;
    public TreeNode remLeaves_01(TreeNode node) {
        if(node.left == null && node.right == null) {
            smallAns.add(node.val);
            return null;
        }
        if(node.left!=null) node.left = remLeaves_01(node.left);
        
        if(node.right!=null) node.right = remLeaves_01(node.right);
        
        return node;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        while(true) {
            smallAns = new ArrayList<>();
            if(root !=null) {
                root = remLeaves_01(root); 
            }
            else break;
            ans.add(smallAns);
        }
        return ans;
    }
}