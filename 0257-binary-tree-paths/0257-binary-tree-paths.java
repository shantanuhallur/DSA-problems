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
    public void binaryTreePaths_01(TreeNode node, ArrayList<String> ans,String currPath) {
        //Base case of LEAF
        if(node.left == null && node.right == null) {
            currPath += node.val;
            ans.add(currPath);
            return;
        }
        //Update our CurrPath
        currPath += node.val +"->";
        //Make calls and recurse in left and right of node if exists.
        if(node.left != null) binaryTreePaths_01(node.left,ans,currPath);
        if(node.right != null) binaryTreePaths_01(node.right,ans,currPath);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>(); 
        binaryTreePaths_01(root,ans,"");
        return ans;
    }
}