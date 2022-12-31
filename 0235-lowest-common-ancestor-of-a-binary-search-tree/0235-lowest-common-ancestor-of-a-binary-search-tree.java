/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        
        while(curr!=null) {
            //IF our curr's val is smaller we need to search in right
            if(curr.val<p.val && curr.val < q.val) {
                curr = curr.right;
            }
            //IF our curr's val is greater we need to search in left
            else if(curr.val > p.val && curr.val > q.val) {
                curr = curr.left;
            }
            //ALREADY IN RANGE
            else return curr;
        }
        
        return curr;
    }
}