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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
       
        
        dfs(root,targetSum,curr,ans);
       // System.out.print(curr); IZ BLANK
        return ans;
    }
    public void dfs(TreeNode node,int target,List<Integer>                              curr,List<List<Integer>>ans){
         if(node==null)return;
        
        curr.add(node.val);
        
        if(node.left==null && node.right==null && target==node.val){
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
 
        }
        else{
            
            dfs(node.left,target-node.val,curr,ans);
            dfs(node.right,target-node.val,curr,ans);
        }
     
       
        
        curr.remove(curr.size()-1);

    }
}