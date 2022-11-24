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
    
    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> ans,List<Integer> curr) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            if( targetSum-root.val==0){
              ArrayList<Integer> base = new ArrayList<>(curr);
                base.add(root.val);
                ans.add(base);   
            }
            return;
        }
        curr.add(root.val);
        
        pathSum(root.left,targetSum-root.val,ans,curr);
        pathSum(root.right,targetSum-root.val,ans,curr);
        
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        pathSum(root,targetSum,ans,new ArrayList<>());
        return ans;
    }
}