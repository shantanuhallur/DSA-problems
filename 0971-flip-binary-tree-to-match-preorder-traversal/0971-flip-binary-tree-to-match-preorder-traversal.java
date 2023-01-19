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
    int i=0;
    public boolean dfs(TreeNode node,int[] arr,ArrayList<Integer> ans) {
        if(node == null) return true; //is equal
        if(node.val!= arr[i++]) return false; //is not equal set up i for child 
        //now i for child is set up and we can compare i with child.
        if(node.left!= null && node.left.val != arr[i]) {
            ans.add(node.val);
            return dfs(node.right,arr,ans) && dfs(node.left,arr,ans);
        }
        
        return dfs(node.left,arr,ans) && dfs(node.right,arr,ans);
    }
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        ArrayList<Integer> ans = new ArrayList<>();
        return dfs(root,voyage,ans) ? ans : Arrays.asList(-1);
    }
}