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
    public void binaryTreePaths_01(TreeNode node,String currPath,ArrayList<String> ans) {
        if(node.left==null && node.right == null) {
            ans.add(currPath + node.val);
            return;  
        } 
        
        currPath += node.val + "->";
        if(node.left != null)binaryTreePaths_01(node.left,currPath,ans);    
        if(node.right != null)binaryTreePaths_01(node.right,currPath,ans);    
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> ans = new ArrayList<>();
        binaryTreePaths_01(root,"",ans);
        return ans;
    }
}