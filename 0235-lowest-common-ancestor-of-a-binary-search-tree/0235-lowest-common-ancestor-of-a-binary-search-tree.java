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
    public TreeNode lowestCommonAncestor_01(TreeNode curr, TreeNode p, TreeNode q) {
         if(curr == null) return curr;
        
                if(curr.val > p.val && curr.val > q.val) {
                    curr = lowestCommonAncestor(curr.left,p,q);
                }
                else if(curr.val < p.val && curr.val < q.val) {
                    curr = lowestCommonAncestor(curr.right,p,q);
                }
                else {
                    return curr;
                }
        return curr;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode curr = root;
            return lowestCommonAncestor_01(curr,p,q);
           
        }
    }
