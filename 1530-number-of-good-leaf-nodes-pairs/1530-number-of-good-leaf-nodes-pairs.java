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
    int count=0;
    public int[] getPair(TreeNode node,int d) {
        if(node == null) return new int[]{};
        if(node.left == null && node.right == null) {
            return new int[]{1};
        }
        
        int[] lAns = getPair(node.left,d);
        int[] rAns = getPair(node.right,d);
        
        int n = lAns.length; int m = rAns.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(lAns[i] + rAns[j] <= d) count++;
            }
        }
        
        int i=0;
        int[] res = new int[n+m];
        for(int val:lAns) res[i++] = val+1;
        for(int val:rAns) res[i++] = val+1;
        
        return res;
    }
    public int countPairs(TreeNode root, int distance) {
        if(distance <=1 || root==null) return 0;
        getPair(root,distance);
        return count;
    }
}