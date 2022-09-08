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
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if(root == null)return res;
        
        goTree(res,"",root);
        
        return res;
    }
    public void goTree(List<String> res,String curr , TreeNode node){
        if(node.left == null && node.right == null){
            res.add(curr+node.val);
        }
        
        if(node.left !=null)goTree(res,curr+node.val + "->",node.left);
        if(node.right !=null)goTree(res,curr+node.val + "->",node.right);
    }
}