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
    String ans = "";
    public void getString(TreeNode node,String s) {
        char sub = (char)('a' + node.val);
        s = String.valueOf(sub) + s;
        if(node.left == null && node.right == null) {
            if(ans == "") {
                ans = s;
            }
            else {
                if(ans.compareTo(s)>=1) ans = s;
            }
        }
        if(node.left!=null) getString(node.left,s);
        if(node.right!=null) getString(node.right,s);
    }
    public String smallestFromLeaf(TreeNode root) {
        getString(root,"");
        return ans;
    }
}