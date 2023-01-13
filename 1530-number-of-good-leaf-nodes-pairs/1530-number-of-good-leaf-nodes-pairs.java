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
    int count = 0;
    //faith each node will return all the leaves nodes distances under that node
    public int[] getPairs(TreeNode node,int d) {
        if(node==null) return new int[]{};
        if(node.left == null && node.right == null) return new int[]{1};
        
        int[] lAns = getPairs(node.left,d);
        int[] rAns = getPairs(node.right,d);
        
        for(int val1 : lAns) {
            for(int val2 : rAns) {
                if(val1+val2 <= d) count++;
            }
        }
        int n = lAns.length , m = rAns.length;
        int[] myAns = new int[n+m];
        int i = 0;
        for(int val1:lAns) myAns[i++] = val1+1;
        for(int val2:rAns) myAns[i++] = val2+1;
        
        return myAns;
    }
    public int countPairs(TreeNode root, int distance) {
        if(root == null || distance <= 1) return 0;
        getPairs(root,distance);
        return count;
    }
}