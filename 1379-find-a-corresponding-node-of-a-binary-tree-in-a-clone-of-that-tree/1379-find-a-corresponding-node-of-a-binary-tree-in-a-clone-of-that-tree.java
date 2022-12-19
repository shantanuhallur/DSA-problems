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
    
    public final TreeNode getTargetCopy_01(final TreeNode node, final TreeNode tar) {
        //preOrder work.
        if(node.val == tar.val) return node;
        //Recursive call for left
        if(node.left != null) {
            TreeNode left = getTargetCopy_01(node.left,tar);
            if(left.val == tar.val) return left;
        }
        //Recursive call for right
        if(node.right != null) {
            TreeNode right = getTargetCopy_01(node.right,tar);
            if(right.val == tar.val) return right;
        }
        
        return new TreeNode(-1);
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode ans = getTargetCopy_01(cloned, target);
        return ans;
    }
}