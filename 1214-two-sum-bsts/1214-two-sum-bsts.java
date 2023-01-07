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
    void traverse(TreeNode node,int target,HashSet<Integer> set) {
        if(node == null) return;
        
        set.add(target - node.val);
        traverse(node.left,target,set);
        traverse(node.right,target,set);
    }
    
    boolean traverse1(TreeNode node,HashSet<Integer> set) {
        if(node == null) return false;
        
        if(set.contains(node.val)) return true;
        boolean left = traverse1(node.left,set);
        boolean right = traverse1(node.right,set);
        return (left || right);
    }
    
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> set = new HashSet<>();
        traverse(root1,target,set);
        return traverse1(root2,set);
    }
}