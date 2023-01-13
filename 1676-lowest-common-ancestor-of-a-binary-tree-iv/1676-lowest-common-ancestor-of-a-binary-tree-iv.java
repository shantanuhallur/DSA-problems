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
    
    public int getLCA (TreeNode node,HashSet<Integer> set) {
        if(node == null) return 0;
        
        int leftFound = getLCA(node.left,set);
        int rightFound = getLCA(node.right,set);
        int totalFound = leftFound + rightFound;
        if(set.contains(node.val)) totalFound++;
        if(LCA == null && totalFound == set.size()) LCA = node;
        
        return totalFound;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for(TreeNode node : nodes) set.add(node.val);
        getLCA(root,set);
        return LCA;
    }
}