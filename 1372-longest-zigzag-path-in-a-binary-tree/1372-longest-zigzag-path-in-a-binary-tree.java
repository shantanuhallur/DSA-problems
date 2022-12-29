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
    int longest = -1;
    public int longestZigZag_01(TreeNode node,int path) {
        if(node==null) return 0;
        
        int leftLongest = longestZigZag_01(node.left,1);
        int rightLongest = longestZigZag_01(node.right,2);
        
        if(path == 1){
            if(rightLongest+1>longest) longest = rightLongest+1;
            return rightLongest+1;
        }
        else if(path == 2) {
            if(leftLongest+1>longest) longest = leftLongest+1;
            return leftLongest+1;
        }
        else return Math.max(leftLongest,rightLongest);
    }
    
    public int longestZigZag(TreeNode root) {
        int ans = longestZigZag_01(root,0);
        return Math.max(ans,longest);
    }
}