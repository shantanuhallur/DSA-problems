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
    TreeNode LCA = null;
    public int getLCA(TreeNode node,HashSet<Integer> set) {
        if(node==null) return 0;
        
        int leftCount = getLCA(node.left,set);
        int rightCount = getLCA(node.right,set);
        int totalCount = leftCount+rightCount;
        if(set.contains(node.val)) totalCount++;
        if(LCA==null && totalCount==set.size()) LCA = node;
        
        return totalCount;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for(TreeNode node : nodes) {
            set.add(node.val);
        }
        getLCA(root,set);
        return LCA;
    }
}