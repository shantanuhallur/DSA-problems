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
    int paths=0;
    public void dfs(TreeNode node, int[] arr) {
        if(node.left == null && node.right == null) {
            arr[node.val]++;
            int odd=0;
            for(int i=1;i<=9;i++) {
                if(arr[i]%2==1) odd++;
            }
            if(odd<=1) paths++;
            arr[node.val]--;
            return;
        }
        
        arr[node.val]++;
        if(node.left!=null) dfs(node.left,arr);
        if(node.right!=null)dfs(node.right,arr);
        arr[node.val]--;
        
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        dfs(root,arr);
        return paths;
    }
}