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
    public void traverse(TreeNode node,int target,HashSet<Integer> set) {
        //Base Case
        if(node == null) return;
        // Fill the set
        set.add(target - node.val);
        //left and right recursive call
        traverse(node.left,target,set);
        traverse(node.right,target,set);
    }
    
    public boolean traverse1(TreeNode node,HashSet<Integer> set) {
        //Base Case
        if(node == null) return false;
        //check if set contains Y -> (target-x)
        if(set.contains(node.val))return true;
        //else run left and righ recursive calls
        boolean leftFound = traverse1(node.left,set);
        boolean rightFound = traverse1(node.right,set);
        
        return leftFound || rightFound;
    }
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> set = new HashSet<>();
        traverse(root1,target,set);
        return traverse1(root2,set);
    }
}