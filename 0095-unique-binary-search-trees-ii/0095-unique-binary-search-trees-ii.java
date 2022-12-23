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
    public List<TreeNode> generateTrees_01(int st,int e) {
        if(st>e){
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(null);
            return base;
        }
        
        ArrayList<TreeNode> ans = new ArrayList<>();
        for(int i=st;i<=e;i++) {
            List<TreeNode> leftTrees = generateTrees_01(st,i-1);
            List<TreeNode> rightTrees = generateTrees_01(i+1,e);
            
            
            for(TreeNode leftTree : leftTrees) {
                for(TreeNode rightTree: rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    ans.add(root);
                }
            } 
        } 
        
        return ans;
    }
    
    public List<TreeNode> generateTrees(int n) {
        
       return generateTrees_01(1,n);
    }
}