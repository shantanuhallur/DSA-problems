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
    int paths = 0;
    public void dfs(TreeNode node,int[] arr) {
        //LEAF
        if(node.left == null && node.right == null) {
            arr[node.val]++;
            int oddFreqCount=0;
            //check if potential palindrome
            for(int i=1;i<=9;i++) {
                if(arr[i]%2 == 1) oddFreqCount++;
            }
            //check if the path is pseudo palindromic
            if(oddFreqCount <=1) paths++;
            arr[node.val]--;
        }
        arr[node.val]++;
        //recurse left and right
        if(node.left !=null) dfs(node.left,arr);
        if(node.right !=null) dfs(node.right,arr);
        arr[node.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];
        dfs(root,arr);
        return paths;
    }
}