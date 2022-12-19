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
    
    public final TreeNode getTargetCopy_01(TreeNode cloned, final TreeNode target) {
        if(cloned==null) return new TreeNode();
        
        if(cloned.val == target.val){
            return cloned;
        }
        if(cloned.left!=null){
            TreeNode left = getTargetCopy_01(cloned.left,target);
            if(left.val == target.val) return left;
        }
        
        if(cloned.right!=null){
            TreeNode right = getTargetCopy_01(cloned.right,target);
            if(right.val == target.val) return right;
        }
        return new TreeNode();
    }
    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode ans = getTargetCopy_01(cloned,target);
        return ans;
    }
}